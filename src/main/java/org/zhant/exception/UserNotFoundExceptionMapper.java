package org.zhant.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFound> {
    @Override
    public Response toResponse(UserNotFound userNotFound) {
        return Response.status(Response.Status.NOT_FOUND).entity("O usuário não foi encontrado").build();
    }
}
