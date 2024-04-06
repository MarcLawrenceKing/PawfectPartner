package com.app.view;

import com.app.controller.AdminController;
import com.app.controller.UserController;
import com.app.model.Account;
import java.util.Scanner;

/*
    this class represents the view for logging in to an account 
*/
public class LoginAccount {
    /*
        displays the login interface and authenticates user credentials 
    */
    public void loginAccount(){
        Scanner sc = new Scanner(System.in); // initialize a scanner object for user input
        Account account = new Account(); // initialize an account object to store user credentials
        UserController uc = new UserController(); // instantiate the controller for user operataions
        DisplayHomePage dhp = new DisplayHomePage(); // instantiate the view for displaying the home page
        AdminController adc = new AdminController(); // instantiate the controller for admin operations
        
        System.out.print("Enter username: ");
        account.setUsername(sc.nextLine()); // prompt user for username and set it in the account object
        System.out.print("Enter password: "); 
        account.setPassword(sc.nextLine()); // prompt user for password and set it in the account object
        
        if (account.getUsername().equals("admin")) { // if user is an admin
            adc.logInAccountAdmin(account); // authenticate admin credentials 
            dhp.displayHomePage(sc); // display home page after admin log in 
        }

        else { // if user is not an admin
        uc.logInAccount(account); // authenticate user credentials
        }
               
    }
}
