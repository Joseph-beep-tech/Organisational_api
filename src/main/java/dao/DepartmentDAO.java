package dao;

import models.Department;
import models.DepartmentNews;
import models.User;

import java.util.List;
import java.util.Objects;

public interface DepartmentDAO{
    List<Department> getAllDepartments();
}