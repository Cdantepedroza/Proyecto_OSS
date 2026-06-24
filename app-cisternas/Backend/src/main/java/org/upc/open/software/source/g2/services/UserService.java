package org.upc.open.software.source.g2.services;

import org.upc.open.software.source.g2.models.requests.UserRequest;
import org.upc.open.software.source.g2.models.requests.UserUpdateRequest;
import org.upc.open.software.source.g2.models.responses.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getUsers();

    UserResponse postUser(UserRequest user);

    UserResponse updateUser(Integer id, UserUpdateRequest request);

    UserResponse deleteUser(Integer id);
}
