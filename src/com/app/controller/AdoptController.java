package com.app.controller;

// importing necessary packages and classes
import com.app.repository.AdoptRepository;
import com.app.pawfect.DBConnection;
import com.app.model.Account;
import com.app.model.Pets;
import static com.app.model.QueryConstant.AD_PENDING_ADOPTIONS;
import static com.app.model.QueryConstant.AD_PET_TYPES;
import static com.app.model.QueryConstant.AD_UPDATE_TO_FOR_ADOPTION;
import static com.app.model.QueryConstant.AD_UPDATE_TO_PENDING;
import java.util.ArrayList;
import java.util.Scanner;

// in this class, it manages the adoption functionalities and interactions with the database
public class AdoptController extends DBConnection implements AdoptRepository {
    Scanner sc = new Scanner(System.in);

    // method that fetch pending adoption profiles from the database
    @Override
    public ArrayList<Pets> adPendingAdoptions(Pets pet) { // reads the database
      
        ArrayList<Pets> petList = new ArrayList<>(); // store pets adopter is adopting (pending and approved)
        try {
            connect(); // establishing database connection
            prep = con.prepareStatement(AD_PENDING_ADOPTIONS); // preparing SQL statement to retrieve pending adoption data
            prep.setInt(1, pet.getAdopter_id()); // setting adopter ID parameter
            
            result = prep.executeQuery(); // executing the query
            System.out.println();
            while (result.next()) {
                //  extracting pet details from the result set
                pet.setPet_id(result.getInt("pet_id"));
                pet.setPet_name(result.getString("pet_name"));
                pet.setPet_age(result.getInt("pet_age"));
                pet.setPet_breed(result.getString("pet_breed"));
                pet.setPet_prevState(result.getString("pet_prevstate"));
                pet.setPet_status(result.getString("pet_status"));
                pet.setAdopter_id(result.getInt("adopter_id"));
                pet.setOwner_id(result.getInt("owner_id"));
                petList.add(pet); // add each pet to the list
            }            
            con.close(); // closing the database connection
        } catch (Exception e) { // exception handling
            System.err.println(e);
        }
        return petList; // returning the array list of pet details        
    }

    // basta andito na kooo
    @Override
    public ArrayList<Pets> adPetTypes(Account account, int choice) {
        
        ArrayList<Pets> petList = new ArrayList<>();

            try {
                connect();
                prep = con.prepareStatement(AD_PET_TYPES);

                switch (choice) {
                    case 1:
                        prep.setString(1, "DOG");
                        break;
                    case 2:
                        prep.setString(1, "CAT");
                        break;
                    case 3:
                        prep.setString(1, "BIRD");
                        break;
                    case 4:
                        prep.setString(1, "FISH");
                        break;
                    case 5:
                        prep.setString(1, "RODENT");
                        break;
                }

                result = prep.executeQuery();
                int counter = 1;
                while (result.next()) {
                    Pets pets = new Pets();
                    System.out.println("[" + counter++ + "] " + result.getString("pet_name"));
                    pets.setPet_id(result.getInt("pet_id"));
                    pets.setPet_name(result.getString("pet_name"));
                    pets.setPet_age(result.getInt("pet_age"));
                    pets.setPet_breed(result.getString("pet_breed"));
                    pets.setPet_prevState(result.getString("pet_prevstate"));
                    pets.setPet_status(result.getString("pet_status"));
                    pets.setAdopter_id(result.getInt("adopter_id"));
                    pets.setOwner_id(result.getInt("owner_id"));

                    petList.add(pets);
                }                                                
            } catch (Exception e) {
                System.err.println(e);
            }       
            return petList;
    }

    @Override
    public void ADUpdateToFOR_ADOPTION(Pets pet) {// for pending adoption
         // to be updated...

        try {
            connect();
            prep = con.prepareStatement(AD_UPDATE_TO_FOR_ADOPTION);
            prep.setString(1, "FOR ADOPTION"); // need palitan
            prep.setInt(2, pet.getPet_id());
            prep.executeUpdate();

            System.out.println("Pet status updated successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void ADUpdateToPENDING(Pets pet, Account account) { //for new adoption
        
        try {
            connect();
            prep = con.prepareStatement(AD_UPDATE_TO_PENDING);
            prep.setInt(1, account.getUser_id());
            prep.setString(2, "PENDING AD");           
            prep.setInt(3, pet.getPet_id());
            prep.executeUpdate();
            System.out.println("Pet status updated successfully!");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
