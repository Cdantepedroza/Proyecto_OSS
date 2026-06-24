package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.responses.UserResponse;
import org.upc.open.software.source.g2.services.UserService;


@Path("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GET
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
}
