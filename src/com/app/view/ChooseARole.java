/**
 * The ChooseARole class represents the view for selecting role
 * It dispense functionality to display options for a role, including
 * Adopting a pet or Rehoming a pet
 * This class impart methods to access and adapt account attributes.
 *
 * This class is used by the user interface to accelerate role selections functionality
 * It interconnects with UserController class to updates user account based on the role
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2023
 */
package com.app.view;

import com.app.controller.UserController;
import com.app.model.Account;
import java.util.Scanner;

public class ChooseARole {
        
       /**
        * Showing choices for choosing a role and holds user input.
        * Updating the account of the user based on the role
        *
        * @param account The object representing the user account
        */
        public void chooseARole (Account account) {
                
        /*
         Scanner method named in to get the input from the user
         to be used all throughout the program
	*/       
        Scanner sc = new Scanner(System.in);
        UserController uc = new UserController();
        
        try {
            System.out.println("\n** Choose a Role **");
            System.out.println("[1] Adopt a pet\n[2] Rehome a pet\n[3] Log out");

            System.out.print("Enter your choice => ");
            int choice = sc.nextInt();

            uc.updateAccount(account, choice);
        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
        
    
    }
}
