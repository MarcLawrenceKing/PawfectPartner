/**
 * The RHPetTypes class provides selection for choosing pet types during the rehoming.
 * It allows user to select from different types of a pets.
 *
 * This class impart methods to show the available pet types menu, take user input and proceed.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2023
 */
package com.app.view;

import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

public class RHPetTypes {

    /**
     * Showing the available pet types menu and allows users to select a pet types they want or go back.
     * @param account The object represents the user.
     * @param pet The object represents the pet being rehomed.
     */
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
