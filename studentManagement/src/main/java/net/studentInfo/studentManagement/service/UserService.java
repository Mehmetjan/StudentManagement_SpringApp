package net.studentInfo.studentManagement.service;

import net.studentInfo.studentManagement.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(int userId);
    List<User> getAllUsers();
    User updateUser(User user);
     void deleteUser(int userId);
}
