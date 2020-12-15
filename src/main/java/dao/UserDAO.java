package dao;

import models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User users);

    User findUserById(int id);

    void updateUser(int departmentId, String position, String role, String name, User user);

    void updateUser(User user, String name, String position, String role, int departmentId);

    void clearAllUsers();

//    static User getUserById(int usersId) {
//        return null;
//    }

    Object getAllUser();

//    void add(User users);

    static User getUserById(int id) {
        return null;
    }
}
