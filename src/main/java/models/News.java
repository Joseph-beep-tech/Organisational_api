package models;

import java.security.Timestamp;

public class News{
    private int id;
    private int userId;
    private String type;
    private String content;
    private Timestamp postdate;

    public News(int id, int userId, String type, String content, Timestamp postdate){
            this.id = id;
            this.userId = userId;
            this.content = content;
            this.type = type;
            this.postdate = postdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostdate() {
        return postdate;
    }

    public void setPostdate(Timestamp postdate) {
        this.postdate = postdate;
    }


}