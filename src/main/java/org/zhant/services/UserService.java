package org.zhant.services;

import org.zhant.exception.UserNotFound;
import jakarta.enterprise.context.ApplicationScoped;
import org.zhant.models.User;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public List<User> findAll(Integer page, Integer pageSize){
        return User.findAll().page(page, pageSize).list();
    }

    public User findById(UUID id){
        return User.findById(id);
    }

    public User findByIdWithException(UUID id){
        return (User) User.findByIdOptional(id).orElseThrow(UserNotFound::new);
    }

    public User createUser(User user){
        User.persist(user);
        return user;
    }

    public User updateUser(UUID userId, User userEntity){
        var user = findByIdWithException(userId);

        user.setName(userEntity.getName());
        //userEntity.persist(user);
        return user;
    }

    public void deleteUser(UUID userId){
        var user = findByIdWithException(userId);
        User.deleteById(user.getUserId());
    }
}
