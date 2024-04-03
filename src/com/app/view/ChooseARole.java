
package com.app.view;

import com.app.controller.UserController;
import com.app.model.Account;
import java.util.Scanner;

public class ChooseARole {

        public void chooseARole (Account account) {
        Scanner sc = new Scanner(System.in);
        UserController uc = new UserController();
        
        System.out.println("** Choose a Role **");
        System.out.println("[1] Adopt a pet\n[2] Rehome a pet");

        System.out.print("Enter your choice => ");
        int choice = sc.nextInt();

        uc.updateAccount(account, choice);
    
    }
}
