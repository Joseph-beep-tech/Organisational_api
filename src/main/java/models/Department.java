package models;


public class Department{
    private int id;
    private String name;
    private String description;

    public Department(int id, String name, String description){
        this.description = description;
        this.id = id;
        this.name = name;
    }
}