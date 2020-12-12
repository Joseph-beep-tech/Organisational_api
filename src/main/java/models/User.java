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
}