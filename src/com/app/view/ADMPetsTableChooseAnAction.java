package com.app.view;

import java.util.Scanner;


public class ADMPetsTableChooseAnAction {
    public void admPetsTableChooseAnAction () {
        ADMChooseATable act = new ADMChooseATable();
        Scanner sc = new Scanner(System.in);
        ADMRetrievePetsArchived adma = new ADMRetrievePetsArchived();
        ADMDeletePets admd = new ADMDeletePets();
        ADMPetsTable adpt = new ADMPetsTable();
        
        System.out.println("\n** Choose An Action **");
        System.out.println("[1] Retrieve \n[2] Delete \n[3] Back");
        System.out.print("Enter your choice => ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1: adma.admRetrievePetsArchived(); break;
            case 2: admd.admDeletePets(); break;
            case 3: adpt.admPetsTable(); break;
            default: 
                System.out.println("Invalid input. Try Again.");
                admPetsTableChooseAnAction();
        }
        
         act.chooseATable();

    }
}
