package models;

public class User{
    private int id;
    private int departmentId;
    private String position;
    private String role;

    public User(int id, int departmentId, String position, String role){
            this.departmentId = departmentId;
            this.id = id;
            this.position = position;
            this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}