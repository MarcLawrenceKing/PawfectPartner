package com.app.controller;


import com.app.model.Pets;
import static com.app.model.QueryConstant.RH_CREATE_PET_PROFILE;
import static com.app.model.QueryConstant.RH_PENDING_ADOPTIONS;
import static com.app.model.QueryConstant.RH_UPDATE_TO_APPROVED;
import static com.app.model.QueryConstant.RH_UPDATE_TO_ARCHIVED;
import com.app.pawfect.DBConnection;
import com.app.repository.RehomeRepository;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class RehomeController extends DBConnection implements RehomeRepository {
    Scanner sc = new Scanner(System.in);
    
    @Override
    public ArrayList<Pets> rhPendingAdoptions(Pets pet) { //reads the database
      
        ArrayList<Pets> petList = new ArrayList<>(); // Store pets adopter is adopting (pending and approved)
        try {
            connect();
            prep = con.prepareStatement(RH_PENDING_ADOPTIONS);
            prep.setInt(1, pet.getOwner_id());
            
            result = prep.executeQuery();
            System.out.println();
            while (result.next()) {

                pet.setPet_id(result.getInt("pet_id"));
                pet.setPet_name(result.getString("pet_name"));
                pet.setPet_age(result.getInt("pet_age"));
                pet.setPet_breed(result.getString("pet_breed"));
                pet.setPet_prevState(result.getString("pet_prevstate"));
                pet.setPet_status(result.getString("pet_status"));
                pet.setAdopter_id(result.getInt("adopter_id"));
                pet.setOwner_id(result.getInt("owner_id"));
                petList.add(pet); // Add each pet to the list
            }            
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return petList;        
    }

    @Override
    public void RHUpdateToAPPROVED(Pets pet){
        try {
            connect();
            prep = con.prepareStatement(RH_UPDATE_TO_APPROVED);
            prep.setString(1, "APPROVED"); 
            prep.setInt(2, pet.getPet_id());
            prep.executeUpdate();

            System.out.println("Pet status updated successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    @Override
    public void RHUpdateToARCHIVED(Pets pet) {

        try {
            connect();
            prep = con.prepareStatement(RH_UPDATE_TO_ARCHIVED);
            prep.setString(1, "ARCHIVED"); // need palitan
            prep.setInt(2, pet.getPet_id());
            prep.executeUpdate();

            System.out.println("Pet status updated successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// Create
    @Override
    public void rhPetProfiles(Pets pet) {    
        try {
            connect();
            
            PreparedStatement statement = con.prepareStatement(RH_CREATE_PET_PROFILE);
            statement.setString(1, pet.getPet_name() );
            statement.setInt(2, pet.getPet_age());
            statement.setString(3, pet.getPet_breed());
            statement.setString(4, pet.getPet_prevState());
            statement.setInt(5, pet.getOwner_id());
            statement.setString(6, pet.getPet_type());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { //exception handling
                System.out.println("Pet added successfully!");
            } else {
                System.out.println("Failed to add pet.");
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }


//    // Delete
//    public void deletePet(Pets pet) {
//        String query = "DELETE FROM tblpets WHERE pet_id = ?";
//        try {
//            connect();
//            PreparedStatement statement = con.prepareStatement(query);
//            statement.setInt(1, pet.getPet_id());
//            statement.executeUpdate();
//            System.out.println("Pet deleted successfully!");
//        } catch (Exception e) {
//            System.err.println(e);
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                System.err.println(e);
//            }
//        }
//    }
}
