package com.app.view;

import java.util.ArrayList;

import com.app.controller.AdminController;
import com.app.model.Account;

public class ADMUsersTable {
    public void admUsersTable (Account account) {
        ArrayList<Account> accountList = new ArrayList<>();
        AdminController adc = new AdminController();
        accountList = adc.ADMUsersTable();

        //Display
        System.out.println("User ID\t\tUsername\t\tFirstName\t\tLast Name\t\t Mobile Number\t\tUser Type");
        System.out.println("===============================================================================");

        for (int i = 0; i < accountList.size(); i++) {
            System.out.print(accountList.get(i).getUser_id());
            System.out.print("\t\t" + accountList.get(i).getUsername());
            System.out.print("\t\t" + accountList.get(i).getfName());
            System.out.print("\t\t" + accountList.get(i).getlName());
            System.out.print("\t\t" + accountList.get(i).getMobile());
            System.out.print("\t\t" + accountList.get(i).getType());
            System.out.println("\n----------------------------------------------------------------------------");
        }
    }
}
