package com.app.repository;

// importing the necessary packages and classes
import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;

/*
    this interface defines the methods for interacting 
    with the admin functionalities
*/

public interface AdminRepository {
    // logs in an admin account 
    public void logInAccountAdmin (Account account); // the method expects an object of the 'Account' thus admin will input a valid one (@admin)
    // retrieves a table of admin users
    public ArrayList<Account> ADMUsersTable(); // returns an ArrayList of account objects representing administrative users
    // retrieves a table of administrative pet details
    public ArrayList<Pets> ADMPetsTable (); // returns an ArrayList of pet objects representing administrative pets
    // deletes archived pets in the administrative system
    public void ADMDeltePetsArchived ();

}
