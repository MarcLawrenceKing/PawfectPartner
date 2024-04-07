/**
 * The AdoptRepository interface defines methods for adoption-related operations. 
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *
 * @version 04/06/2024
*/

package com.app.repository;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;

public interface AdoptRepository {

    /**
     * Retrieves a list of pets pending adoption for a specific adopter.
     *
     * @param pet The pet for which pending adoptions need to be retrieved.
     * @return An ArrayList of Pets objects representing pending adoptions.
     */
    public ArrayList<Pets> adPendingAdoptions(Pets pet);

    /**
     * Retrieves a list of pets based on the specified pet type and user ID.
     *
     * @param account The account of the user requesting the pet types.
     * @param choice The choice representing the pet type (1 for DOG, 2 for CAT, etc.).
     * @return An ArrayList of Pets objects representing the requested pet types.
     */
    public ArrayList<Pets> adPetTypes(Account account, int choice);

    /**
     * Updates the status of a pet to "FOR ADOPTION" for pending adoptions.
     *
     * @param pet The pet for which the status needs to be updated.
     */
    public void ADUpdateToFOR_ADOPTION(Pets pet);

    /**
     * Updates the status of a pet to "PENDING" for new adoptions.
     *
     * @param pet The pet for which the status needs to be updated.
     * @param account The account of the user requesting the adoption.
     */
    public void ADUpdateToPENDING(Pets pet, Account account);
}
