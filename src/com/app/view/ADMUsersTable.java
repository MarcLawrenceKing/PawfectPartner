/**
 * The ADMUsersTable class handles displaying the user accounts table.
 * This class is responsible for displaying the complete details of the users
 * 
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.view;

import java.util.ArrayList;
import com.app.controller.AdminController;
import com.app.model.Account;

public class ADMUsersTable {

    /**
     * Displays the user accounts table.
     */
    public void admUsersTable() {
        try {
            // Retrieve account list from controller
            AdminController adc = new AdminController();
            ArrayList<Account> accountList = adc.admUsersTable();

            // Display table headers
            System.out.println("\nUser ID\t\tUsername\t\tFirstName\t\tLastName\t\tMobile Number");
            System.out.println("=====================================================================================================");

            // Display account information
            for (Account account : accountList) {
                System.out.printf("%-16d%-25s%-25s%-22s%-16s\n" ,
                                    account.getUser_id(), account.getUsername(), account.getfName(),
                                    account.getlName(), account.getMobile());
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
            
            // Prompt the user to choose a table
            ADMChooseATable act = new ADMChooseATable();
            act.chooseATable();
            
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying account information: " + e.getMessage());
        }
    }
}
