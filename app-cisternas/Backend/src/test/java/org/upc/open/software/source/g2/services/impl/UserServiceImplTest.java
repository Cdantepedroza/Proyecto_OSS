package org.upc.open.software.source.g2.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.enterprise.inject.Instance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.upc.open.software.source.g2.models.persistence.User;
import org.upc.open.software.source.g2.models.requests.UserRequest;
import org.upc.open.software.source.g2.models.requests.UserUpdateRequest;
import org.upc.open.software.source.g2.models.responses.UserResponse;

class UserServiceImplTest {

    private EntityManager entityManager;
    private UserServiceImpl userService;

    @BeforeEach
    @SuppressWarnings("unchecked")
    void setUp() {
        Instance<EntityManager> entityManagerInstance = mock(Instance.class);
        entityManager = mock(EntityManager.class);
        when(entityManagerInstance.get()).thenReturn(entityManager);
        userService = new UserServiceImpl(entityManagerInstance);
    }

    @Test
    @SuppressWarnings("unchecked")
    void getUsersShouldReturnMappedResponses() {
        User user = buildUser();
        TypedQuery<User> query = mock(TypedQuery.class);
        when(entityManager.createQuery("select u from User u order by u.id", User.class))
                .thenReturn(query);
        when(query.getResultList()).thenReturn(List.of(user));

        List<UserResponse> result = userService.getUsers();

        assertEquals(1, result.size());
        assertEquals(user.getId(), result.getFirst().getId());
        assertEquals(user.getEmail(), result.getFirst().getEmail());
    }

    @Test
    void postUserShouldPersistAndReturnCreatedUser() {
        UserRequest request = new UserRequest(
                "Ana", "Torres", "ana@example.com",
                "Password123", "CONDUCTOR", null
        );
        LocalDateTime creationDate = LocalDateTime.of(2026, 6, 24, 10, 0);
        doAnswer(invocation -> {
            User persistedUser = invocation.getArgument(0);
            persistedUser.setId(10);
            persistedUser.setFechaCreacion(creationDate);
            return null;
        }).when(entityManager).refresh(any(User.class));

        UserResponse response = userService.postUser(request);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(entityManager).persist(captor.capture());
        verify(entityManager).flush();
        verify(entityManager).refresh(captor.getValue());
        assertEquals("Password123", captor.getValue().getPassword());
        assertEquals("INACTIVO", response.getEstado());
        assertEquals(10, response.getId());
        assertEquals(creationDate, response.getFechaCreacion());
    }

    @Test
    void updateUserShouldModifyOnlyAllowedFields() {
        User user = buildUser();
        when(entityManager.find(User.class, 1)).thenReturn(user);
        String originalPassword = user.getPassword();
        String originalStatus = user.getEstado();
        LocalDateTime originalCreationDate = user.getFechaCreacion();
        UserUpdateRequest request = new UserUpdateRequest(
                "Nombre actualizado",
                "Apellido actualizado",
                "actualizado@example.com",
                "SUPERVISOR"
        );

        UserResponse response = userService.updateUser(1, request);

        assertEquals("Nombre actualizado", user.getNombres());
        assertEquals("Apellido actualizado", user.getApellidos());
        assertEquals("actualizado@example.com", user.getEmail());
        assertEquals("SUPERVISOR", user.getRol());
        assertEquals(originalPassword, user.getPassword());
        assertEquals(originalStatus, user.getEstado());
        assertEquals(originalCreationDate, user.getFechaCreacion());
        assertEquals("SUPERVISOR", response.getRol());
        verify(entityManager).flush();
    }

    @Test
    void updateUserShouldRejectInvalidRoleWithoutAccessingDatabase() {
        UserUpdateRequest request = new UserUpdateRequest(
                "Ana", "Torres", "ana@example.com", "AYUDANTE"
        );

        assertThrows(BadRequestException.class, () -> userService.updateUser(1, request));

        verify(entityManager, never()).find(User.class, 1);
        verify(entityManager, never()).flush();
    }

    @Test
    void updateUserShouldReturnNotFoundWhenUserDoesNotExist() {
        when(entityManager.find(User.class, 99)).thenReturn(null);
        UserUpdateRequest request = new UserUpdateRequest(
                "Ana", "Torres", "ana@example.com", "ADMIN"
        );

        assertThrows(NotFoundException.class, () -> userService.updateUser(99, request));

        verify(entityManager, never()).flush();
    }

    @Test
    void deleteUserShouldPerformLogicalDeletion() {
        User user = buildUser();
        when(entityManager.find(User.class, 1)).thenReturn(user);

        UserResponse response = userService.deleteUser(1);

        assertEquals("INACTIVO", user.getEstado());
        assertEquals("INACTIVO", response.getEstado());
        verify(entityManager).flush();
    }

    @Test
    void deleteUserShouldReturnNotFoundWhenUserDoesNotExist() {
        when(entityManager.find(User.class, 99)).thenReturn(null);

        assertThrows(NotFoundException.class, () -> userService.deleteUser(99));

        verify(entityManager, never()).flush();
    }

    private User buildUser() {
        return new User(
                1,
                "Juan",
                "Pérez",
                "juan@example.com",
                "Password123",
                "CONDUCTOR",
                "ACTIVO",
                LocalDateTime.of(2026, 6, 24, 9, 0)
        );
    }
}
