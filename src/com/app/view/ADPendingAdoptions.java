package com.app.view;

//importing the necessary packages and classes
import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.ArrayList;
import java.util.Scanner;

/*
    this class represents the display for managing the pending adoptions 
*/
public class ADPendingAdoptions {

    /*
        displays pending adoptions and allows users to interact with the system
        parameter pet represents the pet for which pending adoptions are to be displayed
        parameter account is used for accessing the pending adoptions by the owner of the account
    */
    public void adPendingAdoption(Pets pet, Account account){
        ADPendingPetProfile app = new ADPendingPetProfile(); // instantiate the view for pending pet profiles
        Scanner sc = new Scanner(System.in); // initialize a scanner object for user input
        AdoptController ac = new AdoptController(); // instantiate the controller for adoption process
        ArrayList<Pets> pets = new ArrayList<>() ; // initialize an ArrayList to store pending pets
        pets = ac.adPendingAdoptions(pet); // retrieve pending pets from the controller
        int backNum; // variable to represent the number assigned to the back option
        int choice; // variable to store user choice
        
        try {
            do {
                System.out.println("** Pending Adoptions **");
                for (int i = 0; i < pets.size(); i++) {            
                System.out.println("[" + (i + 1) + "] " + pets.get(i).getPet_name());
            }

                backNum = pets.size() + 1; // Number to assign to back option [backNum] Back
                System.out.println("[" + (backNum) + "] Back");
                System.out.print("Enter your choice => ");
                choice = sc.nextInt(); // get user input for choice

                if (choice == backNum) {
                return; // return to the previous menu if the user chooses the back option
    }
                if (choice > 0 && choice >= pets.size()) {
                    Pets petToView = new Pets(); // get the selected pet
                    petToView = pets.get(choice - 1); // display the profile of the selected pet
                    
                    app.adPendingPetProfile(petToView, account); // display the profile of the selected pet
                } 
                
                    sc.close();; // close the scanner to release system resources
        
            } while (true); // repeat the process until the user chooses to go back   
        } catch (Exception e) {
            System.err.println(e); // print any exceptions that occur during the execution
        }

       
        
    }
}
