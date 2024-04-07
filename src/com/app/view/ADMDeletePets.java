/**
 * The ADMDeletePets class allows admin to delete pets from the database.
 * Admin can select a pet from the showed list and delete it.
 *
 * This class impart methods to prompt the user to choose a pet for deletion
 * After deletion, it updates.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2023
 */
package com.app.view;

import com.app.controller.AdminController;
import java.util.Scanner;

public class ADMDeletePets {

    // Prompts the user to choose a pet for deletion and updates the pets table.
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

