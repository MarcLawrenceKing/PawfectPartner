package com.app.model;

public class Account {
    private int user_id;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String mobile;
    private String type;
    private int type_id;
    
    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getType() {
        return type;
    }

    public int getType_id() {
        return type_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setFname(String fName){
        this.fName = fName;
    }

    public void setLname(String lName){
        this.lName = lName;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    public void setType(String type){
        this.type = type;
    }
   
}
