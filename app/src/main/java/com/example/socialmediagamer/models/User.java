package com.example.socialmediagamer.models;

public class User {

    private String id;
    private String email;
    private String username;
    private String phone;
    private Long timestamp;


    public User(){

    }

    public User(String id, String email, String username, String password, String phone, Long timestamp) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public Long getTimestamp() {return timestamp;}

    public void setTimestamp(Long timestamp) {this.timestamp = timestamp;}
}
