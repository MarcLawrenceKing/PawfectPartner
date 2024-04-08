/**
 * The ADPetTypes class handles displaying available pet types for adoption.
 * It provides functionality to display available pet types and manage pet adoptions.
 * This class is used to manage pet types and adoptions within the system.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *  
 * @version 04/07/2024
 */
package com.app.view;

import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.ArrayList;
import java.util.Scanner;


public class ADPetTypes {

    /**
     * Displays available pet types for adoption and allows the user to view profiles and initiate adoptions.
     *
     * @param account The account of the user viewing available pet types.
     */
    public void adPetTypes(Account account){
        AdoptAPet aa = new AdoptAPet();
        Scanner sc = new Scanner(System.in);
        AdoptController ac = new AdoptController();
        ArrayList<Pets> pets = new ArrayList<>() ;
        
            do {

            try {
                int choice;
                System.out.println("\n** Show Pet Types **");
                System.out.println("[1] Dogs\n[2] Cats\n[3] Birds\n[4] Fishes\n[5] Rodents\n[6] Back");
                System.out.print("Enter your choice => ");
                choice = sc.nextInt();

                if (choice == 6) {
                    aa.adoptAPet(account);
                }
                
                if (choice > 0 && choice < 6) {
                    System.out.println("\n** Pet Profiles **");
                    pets = ac.adPetTypes(account, choice);
                    int backNum = pets.size() + 1;
                    System.out.println("[" + backNum + "] Back");
                    System.out.print("Enter pet to view => ");
                    int choice1 = sc.nextInt();

                    if (choice1 == backNum) {
                        pets.clear();
                        continue;
                    }

                    Pets petToView = new Pets();
                    if (choice1 > 0 && choice1 <= pets.size()) {

                        petToView = pets.get(choice1 - 1);
                        
                        System.out.println("\n** Pet Profile **");
                        System.out.println("Name: " + petToView.getPet_name());
                        System.out.println("Age: " + petToView.getPet_age());
                        System.out.println("Pet breed: " + petToView.getPet_breed());
                        System.out.println("Previous Status: " + petToView.getPet_prevState());
                        System.out.println("Status: " + petToView.getPet_status());
                    }

                    System.out.print("Would you like to continue this adoption? [Y/N]: ");
                    char yOrN = sc.next().charAt(0);

                    if (Character.toLowerCase(yOrN) == 'y') {
                        ac.ADUpdateToPENDING(petToView, account); //for new adoption                    
                    } else if (Character.toLowerCase(yOrN) == 'n'){
                        adPetTypes(account);
                    } else {
                        System.out.println("Invalid Input.");
                        adPetTypes(account);
                    }
                }
            
            } catch (Exception e) {
                System.err.println(e);
            }
            
            
        } while (true);

    }
}

