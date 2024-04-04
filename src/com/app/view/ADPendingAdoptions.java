
package com.app.view;

import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.ArrayList;
import java.util.Scanner;


public class ADPendingAdoptions {
    public void adPendingAdoption(Pets pet, Account account){
        ADPendingPetProfile app = new ADPendingPetProfile();
        Scanner sc = new Scanner(System.in);
        AdoptController ac = new AdoptController();
        ArrayList<Pets> pets = new ArrayList<>() ;
        pets = ac.adPendingAdoptions(pet);
        int backNum;
        int choice;
        
        try {
            do {
                System.out.println("** Pending Adoptions **");
                for (int i = 0; i < pets.size(); i++) {            
                System.out.println("[" + (i + 1) + "] " + pets.get(i).getPet_name());
            }

                backNum = pets.size() + 1; // Number to assign to back option [backNum] Back
                System.out.println("[" + (backNum) + "] Back");
                System.out.print("Enter your choice => ");
                choice = sc.nextInt();

                if (choice == backNum) {
                return;
    }
                if (choice > 0 && choice >= pets.size()) {
                    Pets petToView = new Pets();
                    petToView = pets.get(choice - 1);
                    
                    app.adPendingPetProfile(petToView, account);
                } 
                
                    sc.close();;
        
            } while (true);  
        } catch (Exception e) {
            System.err.println(e);
        }

       
        
    }
}
