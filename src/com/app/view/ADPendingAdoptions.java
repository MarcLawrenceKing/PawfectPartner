
package com.app.view;

import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ADPendingAdoptions {
    public void adPendingAdoption(Pets pet, Account account){
                
        AdoptAPet ap = new AdoptAPet();
        ADPendingPetProfile app = new ADPendingPetProfile();
        Scanner sc = new Scanner(System.in);
        AdoptController ac = new AdoptController();
        ArrayList<Pets> pets = new ArrayList<>() ;
        pets = ac.adPendingAdoptions(pet);
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
                ap.adoptAPet(account);
    }
                if (choice > 0 && choice <= pets.size()) {
                    Pets petToView = new Pets();
                    petToView = pets.get(choice - 1);
                    
                    app.adPendingPetProfile(petToView, account);

                } else {
                    System.out.println("Invalid input. Try again.");
                    adPendingAdoption(pet, account);
                }                

        } catch (Exception e) {
            System.err.println(e);
        }
    } while (true);  
              
    }
}
