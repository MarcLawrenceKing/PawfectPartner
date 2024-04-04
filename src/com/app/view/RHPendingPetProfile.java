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
public class RHPendingPetProfile {
    public void rhPendingPetProfile(Pets petToView, Account account){
        
        Scanner sc = new Scanner(System.in);
        RehomeController rc = new RehomeController();
        RehomeAPet rp = new RehomeAPet();

        try {
            System.out.println("Name: " + petToView.getPet_name());
            System.out.println("Age: " + petToView.getPet_age());
            System.out.println("Pet breed: " + petToView.getPet_breed());
            System.out.println("Previous Status: " + petToView.getPet_prevState());
            System.out.println("Status: " + petToView.getPet_status());

            if (petToView.getPet_status().equals("PENDING RH")) { 
                System.out.print("Would you like to approve this adoption? [Y/N]: ");
                char yOrN = sc.next().charAt(0);
        
                if (Character.toLowerCase(yOrN) == 'y') {
                rc.RHUpdateToAPPROVED(petToView);            
              }            
            }

            if (petToView.getPet_status().equals("FOR ADOPTION")) { 
                System.out.print("Would you like to cancel this adoption? [Y/N]: ");
                char yOrN = sc.next().charAt(0);
        
                if (Character.toLowerCase(yOrN) == 'y') {
                    rc.RHUpdateToARCHIVED(petToView);
            
                }
            }     
           
            rp.rehomeAPet(account);
        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
        
        
                                    
}

}
