/**
 * The RHPendingPetProfile class is represents the view for showing pending pet profiles.
 * It stores functionality to show information of pets pending profiles and allow users
 * to approve or cancel the adoption
 *
 * This class by the used by the user  interface to accelerate the viewing of pending adoptions profiles
 * 
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/07/2023
 */
package com.app.view;

import com.app.controller.RehomeController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

public class RHPendingPetProfile {

    /**
     * Showing information of pet's pending adoptions profile and holds user input for 
     * approving or cancelling adoptions
     * 
     * @param petToView The object represents the pet to view the profile
     * @param account The object represents the user account
     */
    public void rhPendingPetProfile(Pets petToView, Account account){

        /*
	     Scanner method named in to get the input from the user
	     to be used all throughout the program
	     */
        Scanner sc = new Scanner(System.in);
        RehomeController rc = new RehomeController();
        RehomeAPet rp = new RehomeAPet();

        try {
            System.out.println("\n** Pending Pet Profile **");
            System.out.println("Name: " + petToView.getPet_name());
            System.out.println("Age: " + petToView.getPet_age());
            System.out.println("Pet breed: " + petToView.getPet_breed());
            System.out.println("Previous Status: " + petToView.getPet_prevState());
            System.out.println("Status: " + petToView.getPet_status());

            if (petToView.getPet_status().equals("PENDING")) { 
                System.out.print("Would you like to approve this adoption? [Y/N]: ");
                char yOrN = sc.next().charAt(0);
        
                if (Character.toLowerCase(yOrN) == 'y') {
                    rc.RHUpdateToAPPROVED(petToView); // Approved the adoption                  
              }
                if (Character.toLowerCase(yOrN) == 'n') {
                    rc.RHUpdateToNOTAPPROVED(petToView); // Not Approved the adoption        
                }
            }

            if (petToView.getPet_status().equals("FOR ADOPTION")) { 
                System.out.print("Would you like to cancel this adoption? [Y/N]: ");
                char yOrN = sc.next().charAt(0);
        
                if (Character.toLowerCase(yOrN) == 'y') {
                    rc.RHUpdateToARCHIVED(petToView); // Cancel the adoption
        
                }
            }     
           
            rp.rehomeAPet(account);  // Return to Rehome a pet after managing status of adoption
        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
                                                    
}

}
