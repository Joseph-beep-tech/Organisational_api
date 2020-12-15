package dao;

import models.User;

public interface Sql2oUsersDAO {
    void add(User users);

    User getUserById(int id);
}
