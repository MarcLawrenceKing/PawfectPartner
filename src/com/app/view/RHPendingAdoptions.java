
package com.app.view;

import com.app.controller.RehomeController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.ArrayList;
import java.util.Scanner;


public class RHPendingAdoptions {
    public void rhPendingAdoption(Pets pet, Account account){
        RHPendingPetProfile app = new RHPendingPetProfile();
        Scanner sc = new Scanner(System.in);
        RehomeController rc = new RehomeController();
        ArrayList<Pets> pets = new ArrayList<>() ;
        pets = rc.rhPendingAdoptions(pet);
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
              return;
            }
            
            if (choice > 0 && choice >= pets.size()) {
              Pets petToView = new Pets();
              petToView = pets.get(choice - 1);
            
              app.rhPendingPetProfile(petToView, account);
            }

          } catch (Exception e) {
            System.out.println(e);
          }
            
        } while (true);    
}
}
