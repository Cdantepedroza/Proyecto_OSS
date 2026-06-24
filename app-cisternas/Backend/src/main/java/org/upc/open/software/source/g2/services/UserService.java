package org.upc.open.software.source.g2.services;

import org.upc.open.software.source.g2.models.responses.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getUsers();
}
