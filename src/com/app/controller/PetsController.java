package com.app.controller;

import com.app.repository.PetsRepository;
import com.app.pawfect.DBConnection;
import com.app.model.Account;
import model.Pets;
import java.util.ArrayList;
import java.util.Scanner;

public class PetsController extends DBConnection implements PetsRepository {
    Scanner sc = new Scanner(System.in);
    //CRUD

    //Read
    public void displayAdoptAPet (Account account) {   //Page for Adopter
        char choice;
        
        do {
            System.out.println("** Adopt a pet **");
            System.out.println("[1] Show your pending adoptions\n[2] Show pet types\n[B] Back");
            System.out.print("Enter your choice => ");
            choice = sc.next().charAt(0);
            Pets pet_control = new Pets();
            pet_control.setAdopter_id(account.getUser_id()); //Sets pet's adopter_id with users_id
            switch (choice) {
                case '1':  
                    displayPets(pet_control);
                    continue;
                case '2':
                    adoptAPet(pet_control);
                    continue;
                case 'B':
                    return;
            } 

        } while (true);
    }

    public void displayPets (Pets pet) {
        String query = "Select * from tblpets where adopter_id = ?";
        ArrayList<Pets> petList = new ArrayList<Pets>(); //Store pets adopter is adopting (pending and approved)
        int counter = 0; //Counter for number of pets
         try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(query);
            System.out.println();
            while (result.next()) {

                pet.setPet_id(result.getInt("pet_id"));
                pet.setPet_name(result.getString("pet_name"));
                pet.setPet_breed(result.getString("pet_breed"));
                pet.setPet_prevState(result.getString("pet_prevState"));
                pet.setPrev_status(result.getString("pet_pet_status"));
                pet.setAdopter_id(result.getInt("adopter_id"));
                pet.setOwner_id(result.getInt("owner_id")); 
                petList.add(pet); //Add each pet to the list
                counter++;
            }

            int backNum;
            int choice;

            do {

                for (int i = 0; i < counter; i++) {
                    System.out.println("[" + (i+1) + "] " + petList.get(i).getPet_name());
                }

                backNum = counter + 1; //Number to assign to back option   [backNum] Back
                System.out.println("\n[" +(backNum) + "] Back");
                System.out.println("Enter your choice => ");
                choice = sc.nextInt();

                if (choice == backNum) {
                    con.close();
                    return;
                }

                if (choice > 0 && choice >= counter) {
                    Pets petToView = new Pets();
                    petToView = petList.get(choice - 1);

                    System.out.println("Name: " + petToView.getPet_name());
                    System.out.println("Age: " + petToView.getPet_age());
                    System.out.println("Pet breed: " + petToView.getPet_breed());
                    System.out.println("Previous Status: " + petToView.getPet_prevState());
                    System.out.println("Status: " + petToView.getPet_status());

                    if (petToView.getPet_status().equals("PENDING")) {
                        System.out.print("Would you like to cancel this adoption? [Y/N]: ");
                        char yOrN = sc.next().charAt(0);

                        if (Character.toLowerCase(yOrN) == 'y') {
                            updatePetsAdopter(petToView);
                        } 
                    } 
                    System.out.println("[B] Back");
                    System.out.println("Enter your choice => ");
                    if (sc.next().charAt(0) == 'B') {
                        continue;
                    }
                }

            } while (true);

         } catch (Exception e) {
            System.err.println(e);
         }

    }

    public void adoptAPet (Pets pet) {
        ArrayList<Pets> petList = new ArrayList<Pets>();
        int choice;

        do {
            System.out.println("** Show Pet Types **");
            System.out.println("[1] Dogs\n[2] Cats\n[3] Birds\n[4] Fishes\n[5] Rodents\n[6] Back");
            System.out.print("\nEnter your choice => ");
            choice = sc.nextInt();
            
            if (choice == 6) {
                return;
            }

            String query = "Select * from tblpets where pet_type = ? and adpter_id = NULL";

            try {

                connect();
                prep = con.prepareStatement(query);
                
                switch (choice) {
                    case 1:
                        prep.setString(1, "Dogs");
                        break;
                    case 2:
                        prep.setString(1, "Cats");
                        break;
                    case 3:
                        prep.setString(1, "Birds");
                        break;
                    case 4:
                        prep.setString(1, "Fishes");
                        break;
                    case 5:
                        prep.setString(1, "Rodents");
                        break;       
                }
                
                result = prep.executeQuery();
                int counter = 1;
                while (result.next()) {
                    System.out.println(result.getInt("[" + counter++ + "] " + result.getString("pet_name")));
                    pet.setPet_id(result.getInt("pet_id"));
                    pet.setPet_name(result.getString("pet_name"));
                    pet.setPet_breed(result.getString("pet_breed"));
                    pet.setPet_prevState(result.getString("pet_prevState"));
                    pet.setPrev_status(result.getString("pet_pet_status"));
                    pet.setAdopter_id(result.getInt("adopter_id"));
                    pet.setOwner_id(result.getInt("owner_id")); 

                    petList.add(pet);
                }

                int backNum = counter + 1;
                System.out.println("[" + backNum + "] Back");
                System.out.println("Enter pet to view => ");
                int choice1 = sc.nextInt();

                if (choice == backNum) {
                    petList.clear();
                    continue;
                }

                Pets petToView = new Pets();
                if (choice1 > 0 && choice1 >= counter) {
                    
                    petToView = petList.get(choice1 - 1);

                    System.out.println("Name: " + petToView.getPet_name());
                    System.out.println("Age: " + petToView.getPet_age());
                    System.out.println("Pet breed: " + petToView.getPet_breed());
                    System.out.println("Previous Status: " + petToView.getPet_prevState());
                    System.out.println("Status: " + petToView.getPet_status());
                }

                System.out.println("Would you like to continue this adoption? [Y/N]: ");
                char yOrN = sc.next().charAt(0);

                if (Character.toLowerCase(yOrN) == 'y') {
                    updatePetsAdopter1(petToView);
                }

            } catch (Exception e) {
                System.err.println(e);
            }
        } while (true);
       
    }
    //Create 
    public void addPets (Pets pet) {
        //add input commands
    }

    //Update 
    public void updatePetsAdopter (Pets pet) {
        String query = "Update tblpets set pet_status = ?, adopter_id = NULL where pet_id = ?"; //to be updated...

        try {
            connect();
            prep = con.prepareStatement(query);
            prep.setString(1, ""); //need palitan
            prep.setInt(2, pet.getPet_id());
            prep.executeUpdate();

            System.out.println("Pet status updated successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void updatePetsAdopter1 (Pets pet) {
        String query = "Update tblpets set adopter_pet = ?, pet status = ? where pet_id = ?";

        try {
            connect();
            prep = con.prepareStatement(query);
            prep.setString(1, "PENDING");
            prep.setInt(2, pet.getAdopter_id());
            prep.setInt(3, pet.getPet_id());
            prep.executeUpdate();
            System.out.println("Pet status updated successfully!");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    //Delete 
    public void deletePets (Pets pet) {

    }
}

    
