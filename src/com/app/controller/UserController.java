package com.app.controller;

import java.util.Scanner;

import com.app.repository.UserRepository;
import com.app.model.Account;
import com.app.pawfect.DBConnection;

public class UserController extends DBConnection implements UserRepository {

    Scanner sc = new Scanner(System.in);
    public void displayHomePage () {
        int choice;
        do {
            System.out.println("==============================");
            System.out.println("|                            |");
            System.out.println("|      PAWFECT Partner       |");
            System.out.println("|                            |");
            System.out.println("==============================");
            
            System.out.println("\n[1] Create Account\n[2] Log In");
            System.out.print("Enter your choice => ");
            choice = sc.nextInt();
            sc.nextLine();

            Account account = new Account();
            if (choice == 1) {
                createAccount(account);
            }
            else if (choice == 2) {
                logInAccount(account);
            }
            else {
                System.out.println("Inavlid input. Try again.");
                continue;
            }
        } while (choice != 1 && choice != 2);
        
    }
    @Override
    public void createAccount(Account account) {
        
        System.out.print("Enter your first name: ");
        account.setFname(sc.nextLine());
        System.out.print("Enter your last name: ");
        account.setLname(sc.nextLine());
        System.out.print("Enter your mobile number: ");
        account.setMobile(sc.nextLine());
        System.out.print("Enter preferred username: ");
        account.setUsername(sc.nextLine());
        System.out.print("Enter preferred password: ");
        account.setPassword(sc.nextLine());
        System.out.println(" ");
        System.out.print("Create account? [Y/N]: ");
        char yOrN = sc.next().charAt(0);

        if (Character.toLowerCase(yOrN) == 'y') {
            String query = "Insert into tblusers(users_username, users_password, users_fName, users_lName, users_mobile) " 
                    + "values (?, ?, ?, ?, ?)";

        try {
            connect();
            prep = con.prepareStatement(query);
            prep.setString(1, account.getUsername()); //palitan ng getter
            prep.setString(2, account.getPassword());
            prep.setString(3, account.getfName());
            prep.setString(4, account.getlName());
            prep.setString(5, account.getMobile());
            
            if (account.getUsername().isEmpty() || account.getPassword().isEmpty() || account.getfName().isEmpty() || account.getlName().isEmpty() || account.getMobile().isEmpty()) {
                System.out.println("Fields cannot be empty.");
            }

            else {
                prep.executeUpdate();
                System.out.println("Account Created Successfully!");
            }
            con.close();
            displayHomePage();
        } catch (Exception e) {
            System.err.println(e);
        }
        }
    }

    @Override
    public void logInAccount (Account account) {
        String query = "Select * from tblusers where users_username = ? and users_password = ?";
        System.out.print("Enter username: ");
        account.setUsername(sc.nextLine());
        System.out.print("Enter password: ");
        account.setPassword(sc.nextLine());

        try {
            connect();
            prep = con.prepareStatement(query);
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
                chooseARole(account);
            }
            else {
                System.out.println("Logged in failed.");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void chooseARole (Account account) {
        System.out.println("** Choose a Role **");
        System.out.println("[1] Adopt a pet\n[2] Rehome a pet");

        System.out.print("Enter your choice => ");
        int choice = sc.nextInt();

        updateAccount(account, choice);
    }

    public void updateAccount (Account account, int choice) {
        String query = "Update tblusers set type_name = ? where users_id = ?";

        try {
            connect();
            prep = con.prepareStatement(query);
            

            switch (choice) {
                case 1:
                    prep.setString(1, "ADOPTER");
                    break;
                case 2:
                    prep.setString(1, "PET OWNER");
                    break;
                default:
                    System.out.println("Invalid Input.");
                    break;
            }
            
            prep.setInt(2, account.getUser_id());
            prep.executeUpdate();
            
        } catch (Exception e) {
            System.err.println(e);
        }

    }

   
}


