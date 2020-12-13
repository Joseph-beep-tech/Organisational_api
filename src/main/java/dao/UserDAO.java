package dao;

import models.User;

import java.util.List;

public interface UserDAO{
    List<User>getAllUsers();
    void addUser(User user);
    User findUserById(int id);
    void updateUser(int departmentId, String position, String role, String name, User user);
    void clearAllUsers();
}