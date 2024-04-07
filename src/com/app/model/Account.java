package com.app.model;

public class Account {
    private int user_id;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String mobile;

    
    public Account(){
        
    }

    public Account(int user_id, String username, String password, String fName, String lName, String mobile, String type, int type_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.mobile = mobile;
    }
    
    
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
    
   
}
