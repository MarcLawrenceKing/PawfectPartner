package com.app.view;

import java.util.Scanner;

/*
    this class represents the interface for displaying the home page of the system
*/
public class DisplayHomePage {
    /*
        displays the home page and allows the user to create an account or log in
        parameter sc is for the scanner object for user input
    */
    public void displayHomePage (Scanner sc) {
        CreateAccount ca = new CreateAccount(); // instantiate the view for creating an account
        LoginAccount la = new LoginAccount(); // instantiate the view for logging in
        
        int choice;
        do {
            System.out.println("==============================");
            System.out.println("|                            |");
            System.out.println("|      PAWFECT Partner       |");
            System.out.println("|                            |");
            System.out.println("==============================");
            
            System.out.println("\n[1] Create Account\n[2] Log In");
            System.out.print("Enter your choice => ");
            choice = sc.nextInt(); // get user input for the choice
            sc.nextLine(); // consume newline character 

            switch (choice) {
                case 1: ca.createAccount(); break; // display create account view
                case 2: la.loginAccount(); break; // display login view 
                default: 
                  System.out.println("Inavlid input. Try again."); break; // prompt user for valid input 
            }
        } while (choice != 1 && choice != 2); // repeat until the user chooses to create an account or log in 
        
    }
}
