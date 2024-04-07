
package com.app.view;

import com.app.controller.AdminController;
import java.util.Scanner;

public class ADMRetrievePetsArchived {
    public void admRetrievePetsArchived(){
        
        ADMChooseATable adct = new ADMChooseATable();
        ADMPetsTableChooseAnAction adpta = new ADMPetsTableChooseAnAction();
        AdminController adc = new AdminController();
        ADMArchivedPetsTable adpt = new ADMArchivedPetsTable();        
        Scanner sc = new Scanner(System.in);
        
        adpt.admArchivedPetsTable();
        
        System.out.print("Select Pet ID you want to retrieve (Press [1] to go back): ");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            adct.chooseATable();
        }
        adc.admRetrievePetsArchived(choice);
        
        System.out.println("\nUpdated Table:");
        adpt.admArchivedPetsTable();
        adpta.admPetsTableChooseAnAction();
        }
    }

