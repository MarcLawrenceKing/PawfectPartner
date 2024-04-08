/**
 * The ADMPetsTableChoose class provides selection for actions to be executed.
 * It allows users to select whether to retrieve, delete or go back to the main table 
 *
 * This class impart methods to showing the options menu, take user input and execute chosen selection
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.view;

import java.util.Scanner;

public class ADMPetsTableChooseAnAction {

    // Showing the options menu for actions on the pets table, take user inpit, and execute chosen selection.
    public void admPetsTableChooseAnAction () {
        ADMChooseATable act = new ADMChooseATable();
        Scanner sc = new Scanner(System.in);
        ADMRetrievePetsArchived adma = new ADMRetrievePetsArchived();
        ADMDeletePets admd = new ADMDeletePets();
        ADMPetsTable adpt = new ADMPetsTable();
        
        System.out.println("\n** Choose An Action **");
        System.out.println("[1] Retrieve \n[2] Delete \n[3] Back");
        System.out.print("Enter your choice => ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1: adma.admRetrievePetsArchived(); break;
            case 2: admd.admDeletePets(); break;
            case 3: adpt.admPetsTable(); break;
            default: 
                System.out.println("Invalid input. Try Again.");
                admPetsTableChooseAnAction();
        }
        
         act.chooseATable();

    }
}
