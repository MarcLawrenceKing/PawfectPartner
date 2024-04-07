/**
 * The UserRepository interface defines methods for user-related operations.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.repository;
import com.app.model.Account;

public interface UserRepository {

    /**
     * Creates a new user account.
     *
     * @param account The account to be created.
     */
    void createAccount (Account account);

    /**
     * Logs in a user account.
     *
     * @param account The account to log in.
     */
    void logInAccount (Account account);

    /**
     * Updates user account details based on the choice provided.
     *
     * @param account The account to be updated.
     * @param choice The choice representing the type of update.
     */
    public void updateAccount (Account account, int choice);
}
