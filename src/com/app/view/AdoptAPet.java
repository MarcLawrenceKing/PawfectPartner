/**
 * The AdoptAPet class is represents the view for adopting a pet.
 * It stores functionality to show options for aopting a pet, including
 * pendiang adoptions and available pet types.
 *
 * This class by the user interface to accelerate pet adoptions functionality.
 * It interconnect with ADPending and ADPetTypes classes.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.view;

import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

public class AdoptAPet {

   /**
    * Showing choices for adopting a pet and holds user input
    * @param account The object representing the user account
    */
    public void adoptAPet(Account account) { // Page for Adopter
        char choice;

        /*
	     Scanner method named in to get the input from the user
	     to be used all throughout the program
	    */
        Scanner sc = new Scanner(System.in);
        ADPendingAdoptions aa = new ADPendingAdoptions();
        ADPetTypes ap = new ADPetTypes();
        ChooseARole cr = new ChooseARole();

        do {
            System.out.println("\n** Adopt a pet **");
            System.out.println("[1] Show your pending adoptions\n[2] Show pet types\n[B] Back");
            System.out.print("Enter your choice => ");
            choice = sc.nextLine().charAt(0);
            choice = Character.toUpperCase(choice);
            Pets pet = new Pets();
            pet.setAdopter_id(account.getUser_id()); // Sets pet's adopter_id with users_id
            switch (choice) {
                case '1':
                    aa.adPendingAdoption(pet,account);  // Calls method of class ADPendingAdoption
                    continue;
                case '2':
                    ap.adPetTypes(account); // Calls method of class ADPetTypes
                    continue;
                case 'B':
                    cr.chooseARole(account); // Go Back
                default: 
                    System.out.println("");
                    System.out.println("Invalid Input");
                    adoptAPet(account);
                    
            }
            System.out.println("");
        } while (true);
        
    }
}
