/**
 * The RHPendingAdoptions class is represents the view for showing pending adoptions.
 * It stores functionality to show the list of pets available for adoption and allow users
 * to see the profiles of the pending pets 
 *
 * This class by the user interface to accelerate the viewing of pending adoptions
 * It interconnect with RehomeController class to redeem the list of pets available.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 * 
 * @version 04/08/2023
 */
package com.app.view;

import com.app.controller.RehomeController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.ArrayList;
import java.util.Scanner;

public class RHPendingAdoptions {
    
   /**
    * Showing a list of pets avail for adoption and holds user input for
    * choosing a pet to view its profiles
    *
    * @param pet The object representing the pet
    * @param account The object representing the user account
    */
    public void rhPendingAdoption(Pets pet, Account account){
        RHPendingPetProfile app = new RHPendingPetProfile();

        /*
	     Scanner method named in to get the input from the user
	     to be used all throughout the program
	    */
        Scanner sc = new Scanner(System.in);
        RehomeController rc = new RehomeController();
        ArrayList<Pets> pets = new ArrayList<>() ;
        pets = rc.rhPendingAdoptions(pet); // Retrieve list of pets available for adoption
        int backNum;
        int choice;
        
        do {
          try {
            System.out.println("** Pending Adoptions **");
            for (int i = 0; i < pets.size(); i++) {            
            System.out.println("[" + (i + 1) + "] " + pets.get(i).getPet_name());
            }
                       
            backNum = pets.size() + 1; // Number to assign to back option [backNum] Back
            System.out.println("[" + (backNum) + "] Back");
            System.out.print("Enter your choice => ");
            choice = sc.nextInt();

            if (choice == backNum) {
              return; // Return if user choose to go back
            }
            
            if (choice > 0 && choice <= pets.size()) {
              Pets petToView = new Pets(); // Retrieve the selected pet
              petToView = pets.get(choice - 1); // View pending adoption profiles of selected pet
            
              app.rhPendingPetProfile(petToView, account);
            } else {
                    System.out.println("Invalid input. Try again.");
                    rhPendingAdoption(pet, account); // Try Again
                } 
            

          } catch (Exception e) {
            System.out.println(e);
          }
            
          
        } while (true);    
}
}
