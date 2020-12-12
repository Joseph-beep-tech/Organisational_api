package models;

import java.util.Objects;

public class User{
    private int id;
    private int departmentId;
    private String position;
    private String role;
    private String name;

    public User(int id, int departmentId, String position, String role, String name){
            this.departmentId = departmentId;
            this.id = id;
            this.position = position;
            this.role = role;
            this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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

@Override
    public boolean equals(Object o){
        if (this == o)return true;
      if (!(o instanceof User))return false;
      User user = (User) o;
      return id == user.id &&
              departmentId == user.departmentId &&
              Objects.equals (name, user.name) &&
              Objects.equals (position, user.position) &&
              Objects.equals (role, user.role);

    }
}