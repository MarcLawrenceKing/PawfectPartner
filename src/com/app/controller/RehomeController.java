/**
 * The RehomeController part of the code is where it can be seen if a Pet Owner will adopt his pets, 
 * because the Profiles of the specific pet he will adopt are placed here. 
 * It can also be seen here if the pet status is APPROVED or ARCHIVED. 
 * And the Owner can also update his pet's profile here.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/06/2023
 */

package com.app.controller;

//Importing necessary classes and packages.
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

/**
 * The RehomeController class implements the operations defined in the RehomeRepository
 * The RehomeController class extends to DBConnection to hold a database interconnection
 */
public class RehomeController extends DBConnection implements RehomeRepository {
    
    /**
     * Scanner method named in to get the input from the user
     * to be used all throughout the program
     */
    Scanner sc = new Scanner(System.in); 
    
    /**
     * Retrieves a listing of pets up for adopting for a particular owners
     * @param pet A object to determine who owns it
     * @return petList A objects that stand in for pets that are up for adoption
     */
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
          
                /**
                 * NOTE: In order to guarantee different situations for every row fetched, 
                 * an additional Pets object needs to be produced within the loop.
                 */
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

    /**
     * Updating a pet's database state to 'APPROVED'
     * @param pet The object that status will be changed.
     */
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

    /**
     * Updating the pet's database status to 'ARCHIVED'
     * @param pet The object that status will be changed.
     */
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

    /**
     * Update the pet database natural state profile 
     * @param pet The object to be attach to the database.
     */
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
