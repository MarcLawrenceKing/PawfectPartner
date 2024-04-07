/**
 * The ADMArchivedPets class is responsible for showing archived pet details.
 * It dispense archived pet data from the database thru the AdminController class.
 * 
 * This class impart methods to access and adapt account attributes.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/08/2023
 */
package com.app.view;

import java.util.ArrayList;
import com.app.controller.AdminController;
import com.app.model.Pets;

public class ADMArchivedPetsTable {

    // Showing the archived pets table
    private void displayPet(Pets pet) {
        System.out.printf("%-16d%-17s%-13d%-22s%-19s%-18s%-18d%-8d%n",
                            pet.getPet_id(), pet.getPet_name(), pet.getPet_age(), 
                            pet.getPet_breed(), pet.getPet_prevState(), pet.getPet_status(),
                            pet.getOwner_id(), pet.getAdopter_id());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    public void admArchivedPetsTable() {
        try {
            // Retrieve archived pet list from controller
            AdminController adc = new AdminController();
            ArrayList<Pets> petList = adc.admArchivedPetsTable();

            // Check if petList is empty
            if (petList.isEmpty()) {
                System.out.println("\nThere are no archived pets.");
                return; // Exit method if petList is empty
            }

            // Display table headers
            System.out.println("\nPet ID\t\tName\t\tAge\t\tBreed\t\tPrevious State\t\tStatus\t\tOwner ID\tAdopter ID");
            System.out.println("==================================================================================================================================");

            // Display archived pet information
            for (Pets pet : petList) {
   
                displayPet(pet);
            }

            // After displaying pets, provide options for user action
            // ADMPetsTableChooseAnAction adtca = new ADMPetsTableChooseAnAction();
            // adtca.admPetsTableChooseAnAction();

        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying archived pet information: " + e.getMessage());
        }
    }
}
