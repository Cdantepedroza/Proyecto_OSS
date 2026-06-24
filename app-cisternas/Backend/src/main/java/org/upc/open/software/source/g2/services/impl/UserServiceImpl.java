package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import org.upc.open.software.source.g2.models.persistence.User;
import org.upc.open.software.source.g2.models.requests.UserRequest;
import org.upc.open.software.source.g2.models.requests.UserUpdateRequest;
import org.upc.open.software.source.g2.models.responses.UserResponse;
import org.upc.open.software.source.g2.services.UserService;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private final Instance<EntityManager> entityManager;

    @Inject
    public UserServiceImpl(Instance<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<UserResponse> getUsers() {
        return entityManager.get()
                .createQuery("select u from User u order by u.id", User.class)
                .getResultList()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(), user.getNombres(), user.getApellidos(),
                        user.getEmail(), user.getRol(), user.getEstado(), user.getFechaCreacion()
                ))
                .toList();
    }

    @Override
    @Transactional
    public UserResponse postUser(UserRequest request) {
        User user = new User();
        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRol(request.getRol());
        if (request.getEstado() == null || request.getEstado().isBlank()) {
            user.setEstado("INACTIVO");
        }
        else {
            user.setEstado(request.getEstado());
        }
        EntityManager manager = entityManager.get();
        manager.persist(user);
        manager.flush();
        manager.refresh(user);
        return new UserResponse(
                user.getId(), user.getNombres(), user.getApellidos(),
                user.getEmail(), user.getRol(), user.getEstado(), user.getFechaCreacion());
    }

    @Override
    @Transactional
    public UserResponse updateUser(Integer id, UserUpdateRequest request) {
        if (request.getRol() == null || !VALID_ROLES.contains(request.getRol())) {
            throw new BadRequestException(
                    "El rol indicado no existe."
            );
        }
        EntityManager manager = entityManager.get();
        User user = manager.find(User.class, id);

        if (user == null) {
            throw new NotFoundException("No se encontró el usuario indicado.");
        }
        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setEmail(request.getEmail());
        user.setRol(request.getRol());
        manager.flush();
        return new UserResponse(
                user.getId(), user.getNombres(), user.getApellidos(),
                user.getEmail(), user.getRol(), user.getEstado(), user.getFechaCreacion());
    }

    @Override
    @Transactional
    public UserResponse deleteUser(Integer id) {
        EntityManager manager = entityManager.get();
        User user = manager.find(User.class, id);

        if (user == null) {
            throw new NotFoundException("No se encontró el usuario con id " + id + ".");
        }
        user.setEstado("INACTIVO");
        manager.flush();
        return new UserResponse(
                user.getId(), user.getNombres(), user.getApellidos(),
                user.getEmail(), user.getRol(), user.getEstado(), user.getFechaCreacion());
    }

    private static final Set<String> VALID_ROLES =
            Set.of("ADMIN", "CONDUCTOR", "SUPERVISOR", "LOGISTICA");
}
