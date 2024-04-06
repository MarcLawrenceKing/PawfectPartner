package com.app.repository;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;

/*
    this interface defines the method for interacting with adoption functionalities
*/
public interface AdoptRepository {

    /* 
        retrieves a list of pending adoptions for a given pet
        the parameter pet is used to represent the pet that is under the pending status to be retrieved
        this method returns an ArrayList of pet objects representing their details
    */
    public ArrayList<Pets> adPendingAdoptions(Pets pet); 

    /*
        retrieves a list of pets based on their types
        the parameter account is used to represent the user accessing the pet types
        the parameter choice is an integer used to represent the user's choice to access the pet details based on their types
        this method returns an ArrayList of pet objects representing the pets of the specified type
    */
    public ArrayList<Pets> adPetTypes(Account account, int choice);

    /*
        updates a pet's status to "For Adoption"
        the parameter pet is used to represent the pet to be updated
    */
    public void ADUpdateToFOR_ADOPTION(Pets pet);

    /*    
        updates a pet's status to "Pending Adoption" and associates it with the adopter's account
        the parameter pet is used to represent the pet to be updated
        the parameter account is the account associated with the pending adoption
    */
    public void ADUpdateToPENDING(Pets pet, Account account);
}
