
package com.app.view;


import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;


public class RehomeAPet {
    public void rehomeAPet(Account account) { 
        char choice;
        Scanner sc = new Scanner(System.in);
          RHPendingAdoptions ra = new RHPendingAdoptions();
          RHPetTypes rt = new RHPetTypes();
                  
        do {
            System.out.println("\n** Rehome a pet **");
            System.out.println("[1] Show your pending adoptions\n[2] Show pet types\n[B] Back");
            System.out.print("Enter your choice => ");
            choice = sc.nextLine().charAt(0);
            Pets pet = new Pets();
            pet.setOwner_id(account.getUser_id()); // Sets pet's owner_id with users_id
            switch (choice) {
                case '1':
                    ra.rhPendingAdoption(pet,account);
                    continue;
                case '2':
                    rt.rhPetTypes(account, pet);
                    continue;
                case 'B':
                sc.close();
                    return;
            }
            System.out.println("");
        } while (true);
    }
}
