
package com.app.view;

import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

public class RHPetTypes {
    public void rhPetTypes(Account account, Pets pet){
        RehomeAPet rap = new RehomeAPet();
        Scanner sc = new Scanner(System.in);
        RHPetProfile rp = new RHPetProfile();
        
            do {
            int choice;
            System.out.println("\n** Show Pet Types **");
            System.out.println("[1] Dogs\n[2] Cats\n[3] Birds\n[4] Fishes\n[5] Rodents\n[6] Back");
            System.out.print("Enter your choice => ");
            choice = sc.nextInt();

            if (choice == 6) {
                rap.rehomeAPet(account);
            }
            
            if (choice > 0 && choice < 6) {
                rp.rhPetProfile(account, pet, choice);
            }
           
        } while (true);

    }
}
