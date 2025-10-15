package com.example.user;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> userList = new ArrayList<>();
    private int idCounter = 1;


    public User addUser(User user) {
        user.setId(idCounter++);
        userList.add(user);
        return user;
    }


    public List<User> getAllUsers() {
        return userList;
    }


    public User getUserById(Integer id) {
        Optional<User> user = userList.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.orElse(null);
    }


    public User updateUser(Integer id, User updatedUser) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setAddress(updatedUser.getAddress());
                return user;
            }
        }
        return null;
    }


    public boolean deleteUser(Integer id) {
        return userList.removeIf(u -> u.getId().equals(id));
    }


}
