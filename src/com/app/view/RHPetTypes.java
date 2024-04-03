
package com.app.view;

import com.app.controller.RehomeController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

public class RHPetTypes {
    public void rhPetTypes(Account account, Pets pet){
        Scanner sc = new Scanner(System.in);
        RehomeController rc = new RehomeController();
        RHPetProfile rp = new RHPetProfile();
        
            do {
            int choice;
            System.out.println("\n** Show Pet Types **");
            System.out.println("[1] Dogs\n[2] Cats\n[3] Birds\n[4] Fishes\n[5] Rodents\n[6] Back");
            System.out.print("Enter your choice => ");
            choice = sc.nextInt();

            if (choice == 6) {
                return;
            }
            
            rp.rhPetProfile(account, pet, choice);
            
            
            
            
//            pets = ac.adPetTypes(account, choice);
//                int backNum = pets.size() + 1;
//                System.out.println("[" + backNum + "] Back");
//                System.out.print("Enter pet to view => ");
//                int choice1 = sc.nextInt();
//
//                if (choice1 == backNum) {
//                    pets.clear();
//                    continue;
//                }
//
//                Pets petToView = new Pets();
//                if (choice1 > 0 && choice1 <= pets.size()) {
//
//                    petToView = pets.get(choice1 - 1);
//
//                    System.out.println("Name: " + petToView.getPet_name());
//                    System.out.println("Age: " + petToView.getPet_age());
//                    System.out.println("Pet breed: " + petToView.getPet_breed());
//                    System.out.println("Previous Status: " + petToView.getPet_prevState());
//                    System.out.println("Status: " + petToView.getPet_status());
//                }
//
//                System.out.print("Would you like to continue this adoption? [Y/N]: ");
//                char yOrN = sc.next().charAt(0);
//
//                if (Character.toLowerCase(yOrN) == 'y') {
//                    ac.ADUpdateToPENDING(petToView, account); //for new adoption
//                   
//                }
        } while (true);

    }
}
