/**
 * The Account class is represents a user account in the system.
 * It stores the user information that will be use on the system.
 * This class impart methods to access and adapt account attributes.
 *
 * This class is used by UserController class to hold user accounts functions.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/07/2024
 */
package com.app.model;

// Instance Variable
public class Account {
    private int user_id;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String mobile;

    //Creating a new Account object with default values.    
    public Account(){
        
    }

    /**
     * Creating a new Account object with the define attributes.
     *
     * @param user_id for User ID
     * @param username for Username
     * @param password for User Password
     * @param fName for User First Name
     * @param lName for User Last Name
     * @param mobile for User Contact
     * @param type for User Account type
     */
    public Account(int user_id, String username, String password, String fName, String lName, String mobile, String type, int type_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.mobile = mobile;
    }
    
    /**
     * Gets the user ID
     * @return user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Gets the username 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the fName
     * @return fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * Gets the lName
     * @return lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * Gets the mobile
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the User ID
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Sets the username
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Sets the password
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Sets the fName
     * @param fName
     */
    public void setFname(String fName){
        this.fName = fName;
    }

    /**
     * Sets the lName
     * @param lName
     */
    public void setLname(String lName){
        this.lName = lName;
    }

    
    /**
     * Sets the mobile
     * @param mobile
     */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
   
}
