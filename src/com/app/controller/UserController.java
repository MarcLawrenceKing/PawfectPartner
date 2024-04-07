/**
 * The UserController is where you can see how users create an Account.
 * how to Log-in and how to Update their accounts if they are an Adopter or Pet Owner.
 *
 * The UserController implements the operations defined in UserRepository.
 * The UserController class extends to DBConnection to hold a database interconnection.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 *
 * @version 04/07/2023
 */
package com.app.controller;

//Importing necessary classes and packages.
import java.util.Scanner;

import com.app.repository.UserRepository;
import com.app.model.Account;
import static com.app.model.QueryConstant.CREATE_ACCOUNT;
import static com.app.model.QueryConstant.LOGIN_ACCOUNT;
import static com.app.model.QueryConstant.UPDATE_ACCOUNT;
import com.app.pawfect.DBConnection;
import com.app.view.AdoptAPet;
import com.app.view.ChooseARole;
import com.app.view.DisplayHomePage;
import com.app.view.RehomeAPet;

public class UserController extends DBConnection implements UserRepository {

    /**
     * Scanner method named in to get the input from the user
     * to be used all throughout the program
     */
    Scanner sc = new Scanner(System.in);
    DisplayHomePage dh = new DisplayHomePage();

    /**
     * Creating a new user account in Database
     * @param account The object who contain account informations
     */
    @Override
    public void createAccount(Account account) {
        try {
            connect();
            prep = con.prepareStatement(CREATE_ACCOUNT);
            prep.setString(1, account.getUsername());
            prep.setString(2, account.getPassword());
            prep.setString(3, account.getfName());
            prep.setString(4, account.getlName());
            prep.setString(5, account.getMobile());

            if (account.getUsername().isEmpty() || account.getPassword().isEmpty() || account.getfName().isEmpty()
                    || account.getlName().isEmpty() || account.getMobile().isEmpty()) {
                System.out.println("Fields cannot be empty.");
            } else {
                prep.executeUpdate();
                System.out.println("\nAccount Created Successfully!");
            }
            con.close();
            dh.displayHomePage();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Accesses a user account that already exists.
     * @param account The object who contain login stuff
     */
    @Override
    public void logInAccount(Account account) {
        DisplayHomePage dhp = new DisplayHomePage();
        ChooseARole cr = new ChooseARole();
        try {
            connect();
            prep = con.prepareStatement(LOGIN_ACCOUNT);
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
                cr.chooseARole(account);
            } else {
                System.out.println("");
                System.out.println("Logged in failed.");
                dhp.displayHomePage();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Accesses a user account that already exists.
     * @param account The object who contain login stuff
     */
    @Override
    public void updateAccount(Account account, int choice) {
        AdoptAPet ap = new AdoptAPet();
        RehomeAPet rp = new RehomeAPet();
        DisplayHomePage dhp = new DisplayHomePage();
        ChooseARole cr = new ChooseARole();

        try {
            connect();
            prep = con.prepareStatement(UPDATE_ACCOUNT);

            switch (choice) {
                case 1:
                    prep.setString(1, "ADOPTER");
                    ap.adoptAPet(account);
                    break;
                case 2:
                    prep.setString(1, "PET OWNER");
                    rp.rehomeAPet(account);
                case 3: 
                    System.out.println("\nLogged Out Successfuly!");
                    dhp.displayHomePage();
                default:
                    System.out.println("Invalid Input. Try Again");
                    cr.chooseARole(account);
                    return;
            }

            prep.setInt(2, account.getUser_id());
            prep.executeUpdate();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
