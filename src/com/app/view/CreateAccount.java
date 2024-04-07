/**
 * The CreateAccount class is represents the view for creating account.
 * It dispense functionality to get user input for a creating a new account
 * including basic info of the users
 *
 * This class by the user interface to accelerate pet adoptions functionality.
 * It interconnect with UserController class for creating new account
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2023
 */
package com.app.view;

import com.app.controller.UserController;
import com.app.model.Account;
import java.util.Scanner;


public class CreateAccount {
    /**
     * Prompts the user to input information for creating new account
     * and holds the account creation activity
     */
    public void createAccount(){
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        UserController uc = new UserController();
        DisplayHomePage dh = new DisplayHomePage();
        try {
            System.out.println("\n** Create Account **");
            System.out.print("Enter your first name: ");
            account.setFname(sc.nextLine());
            System.out.print("Enter your last name: ");
            account.setLname(sc.nextLine());
            System.out.print("Enter your mobile number: ");
            account.setMobile(sc.nextLine());
            System.out.print("Enter preferred username: ");
            account.setUsername(sc.nextLine());
            
            while(account.getUsername().equals("admin")){
                System.out.println("\'admin\' is not acceptable as an username.");
                System.out.print("Enter preferred username: ");
                account.setUsername(sc.nextLine());
            }
                    
            System.out.print("Enter preferred password: ");
            account.setPassword(sc.nextLine());
            System.out.println(" ");
            System.out.print("Create account? [Y/N]: ");
            char yOrN = sc.next().charAt(0);
            
            switch (Character.toLowerCase(yOrN)) {
                case 'y': uc.createAccount(account); // Creating account if user choose 'Y'
                    break;
                case 'n': dh.displayHomePage(); // Return to home page if user choose 'N'
                    break;
                default: 
                    System.out.println("Invalid Input. Try Again.");
                    createAccount();  // Prompt user again. 
                    break;
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    
}
}
