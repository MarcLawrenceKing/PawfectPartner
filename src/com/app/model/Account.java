/**
 * The Account class is where you can see how users create an Account.
 * how to Log-in and how to Update their accounts if they are an Adopter or Pet Owner
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/06/2023
 */

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
    
    public Account(){
        
    }

    public Account(int user_id, String username, String password, String fName, String lName, String mobile, String type, int type_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.mobile = mobile;
        this.type = type;
        this.type_id = type_id;
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
