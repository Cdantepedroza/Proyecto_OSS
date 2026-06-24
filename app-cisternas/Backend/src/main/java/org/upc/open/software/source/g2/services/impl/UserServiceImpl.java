package org.upc.open.software.source.g2.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.upc.open.software.source.g2.models.User;
import org.upc.open.software.source.g2.models.responses.UserResponse;
import org.upc.open.software.source.g2.services.UserService;

import java.util.List;

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
                        user.getId(),
                        user.getNombres(),
                        user.getApellidos(),
                        user.getEmail(),
                        user.getRol(),
                        user.getEstado(),
                        user.getFechaCreacion()
                ))
                .toList();
    }
}
