/**
 * The DisplayHomePage class handles displaying the home page of the application.
 * On this page, you can see the create account or login account option for users
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.view;

import java.util.Scanner;


public class DisplayHomePage {

    /**
     * Displays the home page and prompts the user for action.
     */
    public void displayHomePage () {
        Scanner sc = new Scanner(System.in);
        CreateAccount ca = new CreateAccount();
        LoginAccount la = new LoginAccount();
        
        int choice;
        do {
            System.out.println("\n==============================");
            System.out.println("|                            |");
            System.out.println("|      PAWFECT Partner       |");
            System.out.println("|                            |");
            System.out.println("==============================");
            
            System.out.println("\n[1] Create Account\n[2] Log In\n[3] Exit Program");
            System.out.print("Enter your choice => ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: ca.createAccount(); break;
                case 2: la.loginAccount(); break;
                case 3: System.exit(0);
                default: 
                  System.out.println("");
                  System.out.println("Invalid input. Try again."); break;
            }
        } while (choice != 1 && choice != 2);
        
    }
}
