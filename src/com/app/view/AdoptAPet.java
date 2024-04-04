
package com.app.view;

import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

public class AdoptAPet {
    public void adoptAPet(Account account) { // Page for Adopter
        char choice;
        Scanner sc = new Scanner(System.in);
        ADPendingAdoptions aa = new ADPendingAdoptions();
        ADPetTypes ap = new ADPetTypes();

        do {
            System.out.println("\n** Adopt a pet **");
            System.out.println("[1] Show your pending adoptions\n[2] Show pet types\n[B] Back");
            System.out.print("Enter your choice => ");
            choice = sc.nextLine().charAt(0);
            Pets pet = new Pets();
            pet.setAdopter_id(account.getUser_id()); // Sets pet's adopter_id with users_id
            switch (choice) {
                case '1':
                    aa.adPendingAdoption(pet,account);  //Calls method of class ADPendingAdoption
                    continue;
                case '2':
                    ap.adPetTypes(account); //Calls method of class ADPetTypes
                    continue;
                case 'B':
                    return;
            }
            System.out.println("");
        } while (true);
        
    }
}
