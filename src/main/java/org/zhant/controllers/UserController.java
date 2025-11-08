package org.zhant.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.User;
import services.UserService;
import java.util.UUID;

@Path("/users")//Show the path on routes
@Produces({MediaType.APPLICATION_JSON})//the return type
@Consumes(MediaType.APPLICATION_JSON)//accepts and consume json
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                              @QueryParam("pageSize") @DefaultValue("10") Integer pageSize){
        var users = userService.findAll(page, pageSize);

        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response findbyId(@PathParam("id") UUID userId){
        return Response.ok(userService.findById(userId)).build();
    }

    @GET
    @Path("/finbyID/{id}")
    public Response findByIdWithException(@PathParam("id") UUID userId){
        return Response.ok(userService.findByIdWithException(userId)).build();
    }

    @POST
    @Transactional//all the types of insert need the transaction
    public Response createUser(User user){
        return Response.ok(userService.createUser(user)).build();
    }

    @PUT
    @Transactional//all the types of insert need the transaction
    @Path("/{id}")
    public Response updateUser(@PathParam("id") UUID userId, User user){
        return Response.ok(userService.updateUser(userId, user)).build();
    }

    @DELETE
    @Transactional//all the types of insert need the transaction
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") UUID userId){
        userService.deleteUser(userId);
        return Response.noContent().build();
    }

}
