package dao;


import models.Department;
import models.DepartmentNews;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Sql2oDepartmentDAO implements DepartmentDAO{   //connecting to the interface


    private final Sql2o sql2o;
    private final Sql2oUserDAO userDao;
    private final Sql2oNewsDAO newsDao;

    public Sql2oDepartmentDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
        this.userDao = new Sql2oUserDAO(sql2o);
        this.newsDao = new Sql2oNewsDAO(sql2o);

    }

//    @Override
//    public List<Department> getAllDepartments() {
//        String sql ="select * from departments";
//        try(Connection con = sql2o.open()){
//            return con.createQuery(sql)
//                    .executeAndFetch(Department.class);
//        }
//
//    }

    @Override
    public List<DepartmentNews> getDepartmentNewsById(int id) {
        return null;
    }

    @Override
    public List<User> getDepartmentUserById(int id) {
        return null;
    }

    @Override
    public List<User> getDepartmentUsersById(int id) {
        return userDao.getAllUsers().stream()
                .filter(user -> user.getDepartmentId()==id )
                .collect(Collectors.toList());
    }

//    @Override
//    public void addDepartment(Department department) {
//        String sql = "insert into departments (name,description) values (:name,:description) ";
//        try(Connection con = sql2o.open()){
//            int id = (int) con.createQuery(sql,true)
//                    .bind(department)
//                    .addParameter ( "Production", department.getName ())
//                    .addParameter ( "description", department.getDescription () )
//                    .executeUpdate()
//                    .getKey();
//            department.setId(id);
//        }
//    }

    @Override
    public Department findDepartmentById(int id) {
        String sql ="select * from departments where id=:id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Department.class);
        }

    }

    @Override
    public void upDateDepartment(Department department, String name, String description) {

    }

    @Override
    public void updateDepartment(Department department, String name, String description) {
        String sql ="update departments set (name, description) = (:name, :description) ";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name",name)
                    .addParameter("description",description)
                    .executeUpdate();
            department.setName(name);
            department.setDescription(description);
        }
    }

    public List<Department.DepartmentWithUserCount> getDepartmentWithUserCount(){
        return getAllDepartment().stream()
                .map(dpt->
                        new Department.DepartmentWithUserCount(
                                dpt.getId(),
                                dpt.getName(),
                                dpt.getDescription(),
                                getDepartmentUsersById(dpt.getId()).size()
                        )).collect(Collectors.toList());
    }

    @Override
    public void clearAllDepartments() {
        String sql =" delete from departments";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }
    }


}