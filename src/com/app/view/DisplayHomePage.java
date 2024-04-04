
package com.app.view;

import java.util.Scanner;


public class DisplayHomePage {
    public void displayHomePage (Scanner sc) {
        CreateAccount ca = new CreateAccount();
        LoginAccount la = new LoginAccount();
        
        int choice;
        do {
            System.out.println("==============================");
            System.out.println("|                            |");
            System.out.println("|      PAWFECT Partner       |");
            System.out.println("|                            |");
            System.out.println("==============================");
            
            System.out.println("\n[1] Create Account\n[2] Log In");
            System.out.print("Enter your choice => ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: ca.createAccount(); break;
                case 2: la.loginAccount(); break;
                default: 
                  System.out.println("Inavlid input. Try again."); break;
            }
        } while (choice != 1 && choice != 2);
        
    }
}
