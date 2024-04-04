package com.app.controller;

import static com.app.model.QueryConstant.ADM_DELETE_PETS_ARCHIVED;
import static com.app.model.QueryConstant.ADM_PETS_TABLE;
import static com.app.model.QueryConstant.ADM_USERS_TABLE;
import static com.app.model.QueryConstant.LOGIN_ACCOUNT_ADMIN;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;
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
                System.out.println("");
                ct.chooseATable(account);
                
            } else {
                System.out.println("Logged in failed.");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public ArrayList<Account> ADMUsersTable () {
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
                accountToList.setLname(result.getString("users_lname"));
                accountToList.setType(result.getString("type_name"));
                accountList.add(accountToList);
            }
            con.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return accountList;
        
    }

    @Override
    public ArrayList<Pets> ADMPetsTable () {
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
    public void ADMDeltePetsArchived () {
      
        try {
            connect();
            state = con.createStatement();
            state.executeUpdate(ADM_DELETE_PETS_ARCHIVED);
            System.out.println("Deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
