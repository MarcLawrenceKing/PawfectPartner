package com.app.controller;

import com.app.repository.PetsRepository;
import com.app.pawfect.DBConnection;
import com.app.model.Pets;

public class PetsController extends DBConnection implements PetsRepository {
    // CRUD

    // Read
    public void displayPets(Pets pet) {
        String query = "";

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(query);
            System.out.println();

            while (result.next()) {

            }
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    // Create
    public void addPets(Pets pet) {
        // add input commands
    }

    // Update
    public void updatePets(Pets pet) {
        String query = "Update tblpets set "; // to be updated...

        try {
            connect();
            prep = con.prepareStatement(query);
            prep.setString(0, query); // need palitan
            prep.setString(0, query);

            System.out.println("Pet status updated successfully!");
            // dapat may archive eme pag na update na status
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Delete
    public void deletePets(Pets pet) {

    }
}
