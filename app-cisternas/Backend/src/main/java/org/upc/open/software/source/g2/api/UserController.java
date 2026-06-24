package org.upc.open.software.source.g2.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.upc.open.software.source.g2.models.requests.UserRequest;
import org.upc.open.software.source.g2.models.requests.UserUpdateRequest;
import org.upc.open.software.source.g2.models.responses.UserResponse;
import org.upc.open.software.source.g2.services.UserService;


@Path("/minaya/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GET
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @POST
    public UserResponse postUser(UserRequest user) {
        return userService.postUser(user);
    }

    @PUT
    @Path("/{id}")
    public UserResponse updateUser(
            @PathParam("id") Integer id,
            UserUpdateRequest request
    ) {
        return userService.updateUser(id, request);
    }

    @DELETE
    @Path("/{id}")
    public UserResponse deleteUser(@PathParam("id") Integer id) {
        return userService.deleteUser(id);
    }

}
