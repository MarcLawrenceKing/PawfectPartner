
package com.app.view;

import com.app.controller.UserController;
import com.app.model.Account;
import java.util.Scanner;


public class LoginAccount {
    public void loginAccount(){
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        UserController uc = new UserController();
        
        System.out.print("Enter username: ");
        account.setUsername(sc.nextLine());
        System.out.print("Enter password: ");
        account.setPassword(sc.nextLine());
        
        uc.logInAccount(account);
               
    }
}
