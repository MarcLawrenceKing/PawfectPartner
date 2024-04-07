/**
 * The RehomeRepository interface defines methods for rehoming-related operations.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *
 * @version 04/06/2024
 */
package com.app.repository;

import java.util.ArrayList;

import com.app.model.Pets;

public interface RehomeRepository {

    /**
     * Retrieves a list of pets pending adoption for a specific pet.
     *
     * @param pet The pet for which pending adoptions need to be retrieved.
     * @return An ArrayList of Pets objects representing pending adoptions.
     */
    public ArrayList<Pets> rhPendingAdoptions(Pets pet);

    /**
     * Updates the status of a pet to "APPROVED" for successful adoptions.
     *
     * @param pet The pet for which the status needs to be updated.
     */
    public void RHUpdateToAPPROVED(Pets pet); 

    /**
     * Updates the status of a pet to "NOT APPROVED" for unsuccessful adoptions.
     *
     * @param pet The pet for which the status needs to be updated.
     */
    public void RHUpdateToNOTAPPROVED(Pets pet);

    /**
     * Updates the status of a pet to "ARCHIVED" for completed adoptions.
     *
     * @param pet The pet for which the status needs to be updated.
     */
    public void RHUpdateToARCHIVED(Pets pet); 

    /**
     * Creates profiles for pets available for adoption.
     *
     * @param pet The pet for which the profile needs to be created.
     */
    public void rhPetProfiles(Pets pet);

}
