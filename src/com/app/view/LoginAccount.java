
package com.app.view;

import com.app.controller.AdminController;
import com.app.controller.UserController;
import com.app.model.Account;
import java.util.Scanner;


public class LoginAccount {
    public void loginAccount(){
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        UserController uc = new UserController();
        DisplayHomePage dhp = new DisplayHomePage();
        AdminController adc = new AdminController();
        
        System.out.println("\n** Login Account **");
        System.out.print("Enter username: ");
        account.setUsername(sc.nextLine());
        System.out.print("Enter password: ");
        account.setPassword(sc.nextLine());
        
        if (account.getUsername().equals("admin")) {
            adc.logInAccountAdmin(account);
            dhp.displayHomePage();
        }

        else {
        uc.logInAccount(account);
        }
               
    }
}
