/*
     The ADPetTypes class represents the display for managing pet types and adoptions.
     It provides functionality to display available pet types and manage pet adoptions.
     This class is used to manage pet types and adoptions within the system.

     @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
     
     @version 04/06/2024
*/
package com.app.view;

import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.ArrayList;
import java.util.Scanner;

/*
    this class represents the display for managing pet types and adoptions 
*/
public class ADPetTypes {
    /*   
        displays available pet types and manages pet adoptions 
        parameter account represents the account accessing pet types and adoptions
    */
    public void adPetTypes(Account account){
        Scanner sc = new Scanner(System.in); // initialize a scanner object for user input
        AdoptController ac = new AdoptController(); // instantiate the controller for adoption process
        ArrayList<Pets> pets = new ArrayList<>() ; // initialize an ArrayList to store pes of a specific type
        
            do {

            try {
                int choice;
                System.out.println("\n** Show Pet Types **");
                System.out.println("[1] Dogs\n[2] Cats\n[3] Birds\n[4] Fishes\n[5] Rodents\n[6] Back");
                System.out.print("Enter your choice => "); // get user input for pet type
                choice = sc.nextInt();

                if (choice == 6) { // if user chooses to go back
                    return;
                }
                
                if (choice > 0 && choice < 6) { // if users chooses a valid pet type
                    pets = ac.adPetTypes(account, choice); // retrieve pets for the selected type
                    int backNum = pets.size() + 1; // calculate the number assigned to go back option
                    System.out.println("[" + backNum + "] Back");
                    System.out.print("Enter pet to view => "); 
                    int choice1 = sc.nextInt(); // get user input for viewing pet details

                    if (choice1 == backNum) { // if user chooses to go back
                        pets.clear();
                        continue; // continue to the next iteration of the loop
                    }

                    Pets petToView = new Pets();
                    if (choice1 > 0 && choice1 <= pets.size()) { // if the user selects a valid pet

                        petToView = pets.get(choice1 - 1); // get the selected pet from the ArrayList 

                        System.out.println("Name: " + petToView.getPet_name());
                        System.out.println("Age: " + petToView.getPet_age());
                        System.out.println("Pet breed: " + petToView.getPet_breed());
                        System.out.println("Previous Status: " + petToView.getPet_prevState());
                        System.out.println("Status: " + petToView.getPet_status());
                    }

                    System.out.print("Would you like to continue this adoption? [Y/N]: "); 
                    char yOrN = sc.next().charAt(0); // get user input for continuing adoption

                    if (Character.toLowerCase(yOrN) == 'y') { // if user chooses to continue adoption
                        ac.ADUpdateToPENDING(petToView, account); // update per status to "Pending Adoption"
                    
                    }
                }
            
            } catch (Exception e) {
                System.err.println(e); // print any exceptions that occur during execution 
            }
            
            sc.close(); // close the scanner to release system resources
        } while (true); // repeat until the user chooses to go back

    }
}

