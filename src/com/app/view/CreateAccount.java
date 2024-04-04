
package com.app.view;

import com.app.controller.UserController;
import com.app.model.Account;
import java.util.Scanner;


public class CreateAccount {
    public void createAccount(){
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        UserController uc = new UserController();
        DisplayHomePage dh = new DisplayHomePage();
        try {
            System.out.print("Enter your first name: ");
            account.setFname(sc.nextLine());
            System.out.print("Enter your last name: ");
            account.setLname(sc.nextLine());
            System.out.print("Enter your mobile number: ");
            account.setMobile(sc.nextLine());
            System.out.print("Enter preferred username: ");
            account.setUsername(sc.nextLine());
            System.out.print("Enter preferred password: ");
            account.setPassword(sc.nextLine());
            System.out.println(" ");
            System.out.print("Create account? [Y/N]: ");
            char yOrN = sc.next().charAt(0);
            
            switch (Character.toLowerCase(yOrN)) {
                case 'y': uc.createAccount(account); break;
                case 'n': dh.displayHomePage(sc); break;
                default: 
                    System.out.println("Invalid Input!!");
                    createAccount();
                    break;
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    
}
}
