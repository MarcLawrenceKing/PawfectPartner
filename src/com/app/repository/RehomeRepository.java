package com.app.repository;

import java.util.ArrayList;

import com.app.model.Pets;

/*
    this interface defines the methods for interacting with the rehoming functionalities
*/
public interface RehomeRepository {

    /*
        retrieves a list of pending adoptions for a given pet
        the parameter pet is used to represent the pet for which pending adoptions are to be retrieved
        returns an ArrayList of pet objects representing pending adoptions
    */
    public ArrayList<Pets> rhPendingAdoptions(Pets pet);

    /*
        updates a pet's status to "Approved" for adoption
        the parameter pet is used for the pet to be updated 
    */
    public void RHUpdateToAPPROVED(Pets pet);

    /*
        updates a pet's status to "Archived" after the adoption process
        the parameter is used to represent the pet to be updated
    */
    public void RHUpdateToARCHIVED(Pets pet);

    /*
        retrieves pet profiles for rehoming processes
        the parameter pet is used to represent the pet for which their profiles are to be displayed
    */
    public void rhPetProfiles(Pets pet);

}
