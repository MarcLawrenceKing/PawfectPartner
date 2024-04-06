package com.app.view;

import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

/*
    this class represents the view for displaying pending pet profiles 
*/
public class ADPendingPetProfile {

    /*
        displays the profile of the pending pet and allows the user to cancel the adoption 
        parameter petToView represents the pet whose profile is to be displayed
        parameter account is used for the account accessing the pet profile
    */
    public void adPendingPetProfile(Pets petToView, Account account){
        
        Scanner sc = new Scanner(System.in); // initialize a scanner object for user input
        AdoptController ac = new AdoptController(); // instantiate the controller for adoption operations
        AdoptAPet ap = new AdoptAPet(); // instantiate the view for adopting a pet
        
        try {
            System.out.println("Name: " + petToView.getPet_name());
            System.out.println("Age: " + petToView.getPet_age());
            System.out.println("Pet breed: " + petToView.getPet_breed());
            System.out.println("Previous Status: " + petToView.getPet_prevState());
            System.out.println("Status: " + petToView.getPet_status());

            if (petToView.getPet_status().equals("PENDING AD")) { // check if the pet status is pending adoption
                System.out.print("Would you like to cancel this adoption? [Y/N]: ");
                char yOrN = sc.next().charAt(0); // get user input for canceling adoption
        
                if (Character.toLowerCase(yOrN) == 'y') { // if user chooses to cancel adoption
                    ac.ADUpdateToFOR_ADOPTION(petToView); // update pet status to "For Adoption"
                    ap.adoptAPet(account); // display adoption view for the account
                } 
            }
        } catch (Exception e) {
            System.out.println(e); // print any exception that might occur during execution
        }

        sc.close(); // close the scanner to release system resources 
        
    }
}
