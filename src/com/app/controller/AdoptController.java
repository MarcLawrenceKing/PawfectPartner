package com.app.controller;

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

public class AdoptController extends DBConnection implements AdoptRepository {
    Scanner sc = new Scanner(System.in);

    @Override
    public ArrayList<Pets> adPendingAdoptions(Pets pet) { //reads the database
      
        ArrayList<Pets> petList = new ArrayList<>(); // Store pets adopter is adopting (pending and approved)
        try {
            connect();
            prep = con.prepareStatement(AD_PENDING_ADOPTIONS);
            prep.setInt(1, pet.getAdopter_id());
                        
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
                
               prep.setInt(2, account.getUser_id());
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
            prep.setString(1, "FOR ADOPTION"); 
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
            prep.setString(2, "PENDING");           
            prep.setInt(3, pet.getPet_id());
            prep.executeUpdate();
            System.out.println("Pet status updated successfully!");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
