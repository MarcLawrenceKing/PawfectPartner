/**
 * The ADMChooseTable provides operations to decide a table for administration
 * It dispense options for choosing between users, pets, or logging out.
 *
 * This class impart methods to prompt the user to choose a table
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.view;

import java.util.Scanner;

public class ADMChooseATable {

    // Prompts the user to select a table and redirects to the corresponding views
    public void chooseATable() {
        ADMPetsTableChooseAnAction admca = new ADMPetsTableChooseAnAction();
        Scanner sc = new Scanner(System.in);
        ADMUsersTable admut = new ADMUsersTable();
        ADMPetsTable admpt = new ADMPetsTable();        
        DisplayHomePage dhp = new DisplayHomePage();
        
        System.out.println("\n** Choose A Table **");
        System.out.println("[1] Users\n[2] Pets\n[3] Logout");
        System.out.print("Enter your choice => ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: admut.admUsersTable(); break;
            case 2: admpt.admPetsTable();admca.admPetsTableChooseAnAction();break ;
            case 3: dhp.displayHomePage(); break;
            default:
                System.out.println("Invalid input. Try again.");
                chooseATable();

        }
    }
}
