/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

import com.app.controller.RehomeController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;

/**
 *
 * @author marcl
 */
public class RHPetProfile {
    public void rhPetProfile(Account account, Pets pet, int choice){
                
        Scanner sc = new Scanner(System.in);
        RehomeController rc = new RehomeController();
        RHPetTypes rt = new RHPetTypes();
        
        try {
            System.out.println("** Input Pet Profiles **");
            System.out.print("Enter pet name: ");
            pet.setPet_name(sc.nextLine());
            System.out.print("Enter pet age: ");
            pet.setPet_age(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter pet breed: ");
            pet.setPet_breed(sc.nextLine());
            System.out.print("Enter previous status [PET or RESCUE]: ");
            pet.setPet_prevState(sc.nextLine().toUpperCase());
            
            switch (choice){
                case 1: pet.setPet_type("DOG"); break; 
                case 2: pet.setPet_type("CAT"); break;
                case 3: pet.setPet_type("BIRD"); break;
                case 4: pet.setPet_type("FISH"); break;
                case 5: pet.setPet_type("RODENT"); break;  
            }
                        
            System.out.println("Would you like to continue this adoption? [Y/N]");
            char yOrN = sc.next().charAt(0);
            yOrN = Character.toLowerCase(yOrN);
            
            if (yOrN == 'y') {
            rc.rhPetProfiles(pet);
            rt.rhPetTypes(account, pet);
            } 
            if (yOrN == 'n') {
                rt.rhPetTypes(account, pet);
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
        
                        
    }
    
}
