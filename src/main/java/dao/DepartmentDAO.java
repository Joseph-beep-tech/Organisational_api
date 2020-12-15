package dao;

import models.Department;
import models.DepartmentNews;
import models.User;

import java.util.List;
import java.util.Objects;

public interface DepartmentDAO{
    static List<Department> getAllDepartments() {
        return null;
    }

    List<Department> getDepartments();
//


    List<Department> getAllDepartment();


//    List<Department> getAllDepartments();

    List<DepartmentNews> getDepartmentNewsById(int id);
    List<User> getDepartmentUserById(int id);

    List<User> getDepartmentUsersById(int id);

    static void addDepartment(Department department) {
        return;

    }


//    void addDepartment(Department department);

    Department findDepartmentById(int id);
    void upDateDepartment(Department department, String name, String description);

    void updateDepartment(Department department, String name, String description);

    void clearAllDepartments();

    static Department getDepartmentById(int departmentId) {
        return null;
    }

    static void add(Department departments) {

    }
}
