package com.app.repository;
import com.app.model.Account;

/*
    this interface defines the method for interacting with user account functionalities
*/
public interface UserRepository {

    /*
        creates a new user account
        the parameter account represents the account to be created by the user
    */
    void createAccount (Account account);

    /*
        logs in an existing user account
        the parameter account is used to verify the details of the account to be log in
    */
    void logInAccount (Account account);

    /*
        updates an existing user account based on the specified choice
        the parameter account represents the account to be updated
        the parameter choice is an integer representing the choice of the user
    */
    public void updateAccount (Account account, int choice);
}
