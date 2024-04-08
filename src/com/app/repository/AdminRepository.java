/**
 * The AdminRepository interface defines methods for administrative operations.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.repository;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;

public interface AdminRepository {

    /**
     * Logs in an administrator account.
     *
     * @param account The administrator account to log in.
     */
    public void logInAccountAdmin (Account account);

    /**
     * Retrieves a list of user accounts.
     *
     * @return An ArrayList of Account objects representing user accounts.
     */
    public ArrayList<Account> admUsersTable();

    /**
     * Retrieves a list of pets.
     *
     * @return An ArrayList of Pets objects representing pets.
     */
    public ArrayList<Pets> admPetsTable ();

    /**
     * Retrieves a list of archived pets.
     *
     * @return An ArrayList of Pets objects representing archived pets.
     */
    public ArrayList<Pets> admArchivedPetsTable ();

    /**
     * Deletes a pet from the database.
     *
     * @param choice The ID of the pet to delete.
     */
    public void admDeletePets(int choice);

    /**
     * Retrieves an archived pet from the database and restores it.
     *
     * @param choice The ID of the pet to restore.
     */
    public void admRetrievePetsArchived (int choice);

}
