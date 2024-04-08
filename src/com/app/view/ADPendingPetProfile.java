/**
 * The ADPendingPetProfile class handles displaying pending pet profiles.
 * This is where the system displays the profile of a pending pet and allows the user to cancel the adoption.
 *
 * This class is used to display pending pet profiles and pet status within the system
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *  
 * @version 04/08/2024 
 */
package com.app.view;

import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;


public class ADPendingPetProfile {

    /**
     * Displays the profile of a pet pending adoption.
     *
     * @param petToView The pet for which the profile needs to be displayed.
     * @param account The account of the user viewing the profile.
     */
    public void adPendingPetProfile(Pets petToView, Account account){
        
        ADPendingAdoptions apa = new ADPendingAdoptions();
        Scanner sc = new Scanner(System.in);
        AdoptController ac = new AdoptController();
        AdoptAPet ap = new AdoptAPet();
        
        try {
            System.out.println("\n** Pending Pet Profile **");
            System.out.println("Name: " + petToView.getPet_name());
            System.out.println("Age: " + petToView.getPet_age());
            System.out.println("Pet breed: " + petToView.getPet_breed());
            System.out.println("Previous Status: " + petToView.getPet_prevState());
            System.out.println("Status: " + petToView.getPet_status());

            if (petToView.getPet_status().equals("PENDING")) { 
                System.out.print("Would you like to cancel this adoption? [Y/N]: ");
                char yOrN = sc.next().charAt(0);
        
                if (Character.toLowerCase(yOrN) == 'y') {
                    ac.ADUpdateToFOR_ADOPTION(petToView); // update pet status
                    ap.adoptAPet(account);
                } 
                
                if (Character.toLowerCase(yOrN) == 'n') {
                    apa.adPendingAdoption(petToView, account);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
        
    }
}
