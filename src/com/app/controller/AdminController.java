package com.app.controller;

import static com.app.model.QueryConstant.ADM_DELETE_PETS;
import static com.app.model.QueryConstant.ADM_PETS_TABLE;
import static com.app.model.QueryConstant.ADM_USERS_TABLE;
import static com.app.model.QueryConstant.LOGIN_ACCOUNT_ADMIN;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;
import static com.app.model.QueryConstant.ADM_ARCHIVED_PETS_TABLE;
import static com.app.model.QueryConstant.ADM_RETRIEVE_PETS_ARCHIVED;
import com.app.pawfect.DBConnection;
import com.app.repository.AdminRepository;
import com.app.view.ADMChooseATable;

public class AdminController extends DBConnection implements AdminRepository {
    @Override
    public void logInAccountAdmin (Account account) {
        ADMChooseATable ct = new ADMChooseATable();
        try {
            connect();
            prep = con.prepareStatement(LOGIN_ACCOUNT_ADMIN);
            prep.setString(1, account.getUsername());
            prep.setString(2, account.getPassword());
            result = prep.executeQuery();

            if (result.next()) {
                account.setUser_id(result.getInt("users_id"));
                account.setFname(result.getString("users_fName"));
                account.setLname(result.getString("users_lName"));
                account.setMobile(result.getString("users_mobile"));
                account.setUsername(result.getString("users_username"));
                account.setPassword(result.getString("users_password"));
                System.out.println("");
                System.out.println("Logged in successfully!");
                ct.chooseATable();
                
            } else {
                System.out.println("Logged in failed.");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public ArrayList<Account> admUsersTable () {
        ArrayList<Account> accountList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(ADM_USERS_TABLE);

            while (result.next()) {
                Account accountToList = new Account();
                accountToList.setUser_id(result.getInt("users_id"));
                accountToList.setUsername(result.getString("users_username"));
                accountToList.setPassword("users_password");
                accountToList.setFname(result.getString("users_fname"));
                accountToList.setMobile(result.getString("users_mobile"));
                accountToList.setLname(result.getString("users_lname"));
                accountList.add(accountToList);
            }
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return accountList;
        
    }

    @Override
    public ArrayList<Pets> admPetsTable () {
        ArrayList<Pets> petList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(ADM_PETS_TABLE);

            while (result.next()) {
                Pets petToList = new Pets();
                petToList.setPet_id(result.getInt("pet_id"));
                petToList.setPet_type(result.getString("pet_type"));
                petToList.setPet_name(result.getString("pet_name"));
                petToList.setPet_age(result.getInt("pet_age"));
                petToList.setPet_breed(result.getString("pet_breed"));
                petToList.setPet_prevState(result.getString("pet_prevstate"));
                petToList.setPet_status(result.getString("pet_status"));
                petToList.setOwner_id(result.getInt("owner_id"));
                petToList.setAdopter_id(result.getInt("adopter_id"));
                petList.add(petToList);
            }
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return petList;
        
    }
    
    @Override
    public ArrayList<Pets> admArchivedPetsTable () {
        ArrayList<Pets> petList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(ADM_ARCHIVED_PETS_TABLE);

            while (result.next()) {
                Pets petToList = new Pets();
                petToList.setPet_id(result.getInt("pet_id"));
                petToList.setPet_type(result.getString("pet_type"));
                petToList.setPet_name(result.getString("pet_name"));
                petToList.setPet_age(result.getInt("pet_age"));
                petToList.setPet_breed(result.getString("pet_breed"));
                petToList.setPet_prevState(result.getString("pet_prevstate"));
                petToList.setPet_status(result.getString("pet_status"));
                petToList.setOwner_id(result.getInt("owner_id"));
                petToList.setAdopter_id(result.getInt("adopter_id"));
                petList.add(petToList);
            }
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return petList;
        
    }
    
    @Override
    public void admDeletePets(int choice) {    
        try {
            connect();
            prep = con.prepareStatement(ADM_DELETE_PETS);
            prep.setInt(1, choice);
            int rowsAffected = prep.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("\nDeleted successfully!");
            } else {
                System.out.println("\nNo records deleted. Pet with ID " + choice + " not found.");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void admRetrievePetsArchived (int choice) {
      
        try {
            connect();
            prep = con.prepareStatement(ADM_RETRIEVE_PETS_ARCHIVED);
            prep.setInt(1, choice);
            int rowsAffected = prep.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("\nRecovered successfully!");
            } else {
                System.out.println("\nNo records recovered. Pet with ID " + choice + " not found.");
            }
                       
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
