/**
 * The RehomeAPet class is represents the view for showing rehome pet.
 * It stores functionality for the users to view pending adoptions or pet types 
 * and go back to the previous menu
 *
 * This class by the user interface to accelerate the rehoming process
 * It interconnect with RHPendingAdoptions and RHPetTypes classes to provide choices for
 * the users to view pending adoptions, pet types, or go back to the previous menu
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.view;

import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;


public class RehomeAPet {
    
    /**
     * Showing choices for rehoming a pet and holds user input
     * @param account The object represents the user account
     */
    public void rehomeAPet(Account account) { 
        char choice;
        
        /*
	     Scanner method named in to get the input from the user
	     to be used all throughout the program
	    */
        Scanner sc = new Scanner(System.in);
        RHPendingAdoptions ra = new RHPendingAdoptions();
        RHPetTypes rt = new RHPetTypes();
        ChooseARole cr = new ChooseARole();
                  
        do {
            System.out.println("\n** Rehome a pet **");
            System.out.println("[1] Show your pending adoptions\n[2] Show pet types\n[B] Back");
            System.out.print("Enter your choice => ");
            choice = sc.nextLine().charAt(0);
            choice = Character.toUpperCase(choice);
            Pets pet = new Pets();
            pet.setOwner_id(account.getUser_id()); // Sets pet's owner_id with users_id
            switch (choice) {
                case '1':
                    ra.rhPendingAdoption(pet,account);  // View pending adoptions
                    continue;
                case '2':
                    rt.rhPetTypes(account, pet);  // View pet types
                    continue;
                case 'B':                    
                    cr.chooseARole(account); // Go Back                    
                default: 
                    System.out.println("\nInvalid Input. Try Again.");
                    rehomeAPet(account);
            }
            System.out.println("");
        } while (true);
    }
}
