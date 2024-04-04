package com.app.view;

import java.util.Scanner;

import com.app.model.Account;

public class ADMChooseATable {
    public void chooseATable(Account account) {
        Scanner sc = new Scanner(System.in);
        ADMUsersTable admut = new ADMUsersTable();
        ADMPetsTable admpt = new ADMPetsTable();
        ADMPetsTableChooseAnAction admca = new ADMPetsTableChooseAnAction();
        ADMChooseATable act = new ADMChooseATable();
        System.out.println("** Choose A Table **");
        System.out.println("[1] Users\n[2] Pets\n[3]");
        System.out.print("Enter your choice => ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: admut.admUsersTable(account); act.chooseATable(account); break;
            case 2: admpt.admPetsTable(); admca.admPetsTableChooseAnAction(); act.chooseATable(account);break ;
            case 3: return;

        }
    }
}
