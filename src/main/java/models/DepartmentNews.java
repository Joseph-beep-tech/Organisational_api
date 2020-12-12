package models;

import java.security.Timestamp;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;
        if ( !super.equals ( o ) ) return false;
        DepartmentNews that = (DepartmentNews) o;
        return departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash ( super.hashCode (), departmentId );
    }
}