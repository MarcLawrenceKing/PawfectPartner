/**
 * The RHPetProfile class is represents the view for inputting profiles of a pet
 * It stores functionality to get from the user input to create or update a pet profile
 *
 * This class by the user interface to accelerate the creation or updating of a pet profile
 * It interconnect with RehomeController class to hold the logic for creating or updating
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2023
 */
package com.app.view;

import com.app.controller.RehomeController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;


public class RHPetProfile {

    /**
     * Prompts the user to input pet profiles and holds the adoption activity.
     *
     * @param account The object represents the user account
     * @param pet The object represents the pet
     * @param choice The object represents the decision of the user to selected pet type
     */
    public void rhPetProfile(Account account, Pets pet, int choice){

        /*
	     Scanner method named in to get the input from the user
	     to be used all throughout the program
	    */
        Scanner sc = new Scanner(System.in);
        RehomeController rc = new RehomeController();
        RHPetTypes rt = new RHPetTypes();
        
        try {
            System.out.println("\n** Input Pet Profiles **");
            System.out.print("Enter pet name: ");
            pet.setPet_name(sc.nextLine());
            System.out.print("Enter pet age: ");
            pet.setPet_age(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter pet breed: ");
            pet.setPet_breed(sc.nextLine());
            System.out.print("Enter previous status [PET or RESCUE]: ");
            pet.setPet_prevState(sc.nextLine().toUpperCase());
            
            while(!pet.getPet_prevState().equals("PET") && !pet.getPet_prevState().equals("RESCUE")){
                System.out.println("Invalid Input. Try Again.");
                System.out.print("Enter previous status [PET or RESCUE]: ");
                pet.setPet_prevState(sc.nextLine().toUpperCase());
            }
            
            switch (choice){
                case 1: pet.setPet_type("DOG"); break; 
                case 2: pet.setPet_type("CAT"); break;
                case 3: pet.setPet_type("BIRD"); break;
                case 4: pet.setPet_type("FISH"); break;
                case 5: pet.setPet_type("RODENT"); break;  
            }
                        
            System.out.print("Would you like to continue this adoption? [Y/N]: ");
            char yOrN = sc.next().charAt(0);
            yOrN = Character.toLowerCase(yOrN);

            // Process adoption based on the choice of the users
            if (yOrN == 'y') {
            rc.rhPetProfiles(pet); // Create or update pet profile
            rt.rhPetTypes(account, pet); // Return to select another pet type
            } 
            if (yOrN == 'n') {
                rt.rhPetTypes(account, pet); // Return to select another pet type
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
        
                        
    }
    
}
