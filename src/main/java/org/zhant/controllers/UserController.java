package org.zhant.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.User;
import services.UserService;

@Path("/users")//Show the path on routes
@Produces({MediaType.APPLICATION_JSON})//the return type
@Consumes(MediaType.APPLICATION_JSON)//accepts and consume json
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Transactional//all the types of insert need the transaction
    public Response createUser(User user){
        return Response.ok(userService.createUser(user)).build();
    }
}
