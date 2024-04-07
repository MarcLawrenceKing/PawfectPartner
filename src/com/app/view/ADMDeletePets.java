
package com.app.view;

import com.app.controller.AdminController;
import java.util.Scanner;

public class ADMDeletePets {
    
    public void admDeletePets(){
        
        ADMChooseATable adct = new ADMChooseATable();
        AdminController adc = new AdminController();
        ADMPetsTable adpt = new ADMPetsTable();        
        Scanner sc = new Scanner(System.in);
        
        adpt.admPetsTable();
        
        System.out.print("Select Pet ID you want to delete (Press [1] to go back): ");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            adct.chooseATable();
        }
        
        adc.admDeletePets(choice);
        
        System.out.println("\nUpdated Table:");
        adpt.admPetsTable();
        
        }
        
        
}

