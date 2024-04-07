package com.app.controller;


import com.app.model.Pets;
import static com.app.model.QueryConstant.RH_CREATE_PET_PROFILE;
import static com.app.model.QueryConstant.RH_PENDING_ADOPTIONS;
import static com.app.model.QueryConstant.RH_UPDATE_TO_APPROVED;
import static com.app.model.QueryConstant.RH_UPDATE_TO_ARCHIVED;
import static com.app.model.QueryConstant.RH_UPDATE_TO_NOT_APPROVED;
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
                Pets newPet = new Pets();
                newPet.setPet_id(result.getInt("pet_id"));
                newPet.setPet_name(result.getString("pet_name"));
                newPet.setPet_age(result.getInt("pet_age"));
                newPet.setPet_breed(result.getString("pet_breed"));
                newPet.setPet_prevState(result.getString("pet_prevstate"));
                newPet.setPet_status(result.getString("pet_status"));
                newPet.setAdopter_id(result.getInt("adopter_id"));
                newPet.setOwner_id(result.getInt("owner_id"));
                petList.add(newPet); // Add each pet to the list
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

            System.out.println("\nPet status updated successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    @Override
    public void RHUpdateToNOTAPPROVED(Pets pet){
        try {
            connect();
            prep = con.prepareStatement(RH_UPDATE_TO_NOT_APPROVED);
            prep.setString(1, "NOT APPROVED"); 
            prep.setInt(2, pet.getPet_id());
            prep.executeUpdate();

            System.out.println("\nPet status updated successfully!\nNOTE: You have to create a new pet profile if you wish to put the same pet again FOR ADOPTION.");
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

            System.out.println("\nPet status updated successfully!");
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
                System.out.println("\nPet added successfully!");
            } else {
                System.out.println("\nFailed to add pet.");
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }


}
