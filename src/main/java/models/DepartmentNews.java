package models;

import java.security.Timestamp;

public class DepartmentNews extends News{

    private int departmentId;

    public DepartmentNews(int id, int departmentId, int userId, String type, String content, Timestamp postdate){
        super (id, userId, type, content, postdate);
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}