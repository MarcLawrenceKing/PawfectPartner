package com.app.view;

import java.util.Scanner;

import com.app.controller.AdminController;

public class ADMPetsTableChooseAnAction {
    public void admPetsTableChooseAnAction () {
        Scanner sc = new Scanner(System.in);
        AdminController ac = new AdminController();
        System.out.println("** Choose An Action **");
        System.out.println("[1] Delete");
        System.out.print("Enter your choice => ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1: ac.ADMDeltePetsArchived(); break;
        }

        sc.close();
    }
}
