
package dao;

import models.User;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDAO implements UserDAO, Sql2oUsersDAO {
    private final Sql2o sql2o;

    public Sql2oUserDAO (Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(User users) {
        String sql = "INSERT INTO users (name, position, role, departmentId) VALUES (:name, :position, :role, :departmentId)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .bind(users)
                    .addParameter("name", users.getUsername())
                    .addParameter("position", users.getUserPosition())
                    .addParameter("role", users.getUserRole())
                    .addParameter("departmentId", users.getDepartmentId())
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        }
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM users";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(User.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public void updateUser(int departmentId, String position, String role, String name, User user) {

    }

    @Override
    public void updateUser(User user, String name, String position, String role, int departmentId) {

    }

    @Override
    public void clearAllUsers() {

    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id =:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

}