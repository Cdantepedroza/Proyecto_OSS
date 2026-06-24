package org.upc.open.software.source.g2.api;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.upc.open.software.source.g2.models.requests.UserRequest;
import org.upc.open.software.source.g2.models.requests.UserUpdateRequest;
import org.upc.open.software.source.g2.models.responses.UserResponse;
import org.upc.open.software.source.g2.services.UserService;

class UserControllerTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    void getUsersShouldDelegateToService() {
        List<UserResponse> expected = List.of(buildResponse());
        when(userService.getUsers()).thenReturn(expected);

        assertSame(expected, userController.getUsers());
        verify(userService).getUsers();
    }

    @Test
    void postUserShouldDelegateToService() {
        UserRequest request = new UserRequest(
                "Juan", "Pérez", "juan@example.com",
                "Password123", "CONDUCTOR", "ACTIVO"
        );
        UserResponse expected = buildResponse();
        when(userService.postUser(request)).thenReturn(expected);

        assertSame(expected, userController.postUser(request));
        verify(userService).postUser(request);
    }

    @Test
    void updateUserShouldDelegateToService() {
        UserUpdateRequest request = new UserUpdateRequest(
                "Juan", "Pérez", "juan@example.com", "SUPERVISOR"
        );
        UserResponse expected = buildResponse();
        when(userService.updateUser(1, request)).thenReturn(expected);

        assertSame(expected, userController.updateUser(1, request));
        verify(userService).updateUser(1, request);
    }

    @Test
    void deleteUserShouldDelegateToService() {
        UserResponse expected = buildResponse();
        when(userService.deleteUser(1)).thenReturn(expected);

        assertSame(expected, userController.deleteUser(1));
        verify(userService).deleteUser(1);
    }

    private UserResponse buildResponse() {
        return new UserResponse(
                1,
                "Juan",
                "Pérez",
                "juan@example.com",
                "CONDUCTOR",
                "ACTIVO",
                LocalDateTime.of(2026, Month.JUNE, 24, 9, 0)
        );
    }
}
