/**
 * The ADMPetsTable class is responsible for showing the list of pets/
 * It dispense the list of pets from the controller and formats and prints them in table.
 *
 * This class impart methods to sho the pet table with headers and pet details.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2023
 */
package com.app.view;

import java.util.ArrayList;
import com.app.controller.AdminController;
import com.app.model.Pets;

public class ADMPetsTable {

    // Showing the pet table with headers and pet details.
    public void admPetsTable() {
        try {
            // Retrieve pet list from controller
            AdminController adc = new AdminController();
            ArrayList<Pets> petList = adc.admPetsTable();

            // Display table headers
            System.out.println("\nPet ID\t\tName\t\tAge\t\tBreed\t\tPrevious State\t\tStatus\t\tOwner ID\tAdopter ID");
            System.out.println("====================================================================================================================================");

            // Display pet information
            for (Pets pet : petList) {
                System.out.printf("%-15d%-18s%-13d%-22s%-18s%-20s%-16d%-14d%n", 
                                    pet.getPet_id(), pet.getPet_name(), pet.getPet_age(), 
                                    pet.getPet_breed(), pet.getPet_prevState(), pet.getPet_status(), 
                                    pet.getOwner_id(), pet.getAdopter_id());
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying pet information: " + e.getMessage());
        }
    }
}
