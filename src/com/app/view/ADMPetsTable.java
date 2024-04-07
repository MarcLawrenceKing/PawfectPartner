package com.app.view;

import java.util.ArrayList;
import com.app.controller.AdminController;
import com.app.model.Pets;

public class ADMPetsTable {
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
