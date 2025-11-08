package services;

import jakarta.enterprise.context.ApplicationScoped;
import models.User;

@ApplicationScoped
public class UserService {

    public User createUser(User user){
        User.persist(user);
        return user;
    }
}
