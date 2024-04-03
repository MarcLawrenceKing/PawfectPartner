/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

import com.app.controller.AdoptController;
import com.app.model.Account;
import com.app.model.Pets;
import java.util.Scanner;


public class ADPendingPetProfile {
    public void adPendingPetProfile(Pets petToView, Account account){
        
        Scanner sc = new Scanner(System.in);
        AdoptController ac = new AdoptController();
        AdoptAPet ap = new AdoptAPet();
        
        System.out.println("Name: " + petToView.getPet_name());
            System.out.println("Age: " + petToView.getPet_age());
            System.out.println("Pet breed: " + petToView.getPet_breed());
            System.out.println("Previous Status: " + petToView.getPet_prevState());
            System.out.println("Status: " + petToView.getPet_status());

            if (petToView.getPet_status().equals("PENDING AD")) { 
            System.out.print("Would you like to cancel this adoption? [Y/N]: ");
            char yOrN = sc.next().charAt(0);
        
            if (Character.toLowerCase(yOrN) == 'y') {
            ac.ADUpdateToFOR_ADOPTION(petToView);
            ap.adoptAPet(account);
    }
}
}
}
