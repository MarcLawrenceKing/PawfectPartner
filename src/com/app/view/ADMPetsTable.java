package com.app.view;

import java.util.ArrayList;

import com.app.controller.AdminController;
import com.app.model.Pets;

public class ADMPetsTable {
    public void admPetsTable () {
        ArrayList<Pets> petList = new ArrayList<>();
        AdminController adc = new AdminController();
        petList = adc.ADMPetsTable();

        //Display
        System.out.println("Pet ID\t\tName\t\tAge\t\tBreed\t\tPrevious State\t\tStatus\t\tOwner ID\t\tAdopter ID");
        System.out.println("===============================================================================");

        for (int i = 0; i < petList.size(); i++) {
            System.out.print(petList.get(i).getPet_id());
            System.out.print("\t\t" + petList.get(i).getPet_name());
            System.out.print("\t\t" + petList.get(i).getPet_age());
            System.out.print("\t\t" + petList.get(i).getPet_breed());
            System.out.print("\t\t" + petList.get(i).getPet_prevState());
            System.out.print("\t\t" + petList.get(i).getPet_status());
            System.out.print("\t\t" + petList.get(i).getOwner_id());
            System.out.print("\t\t" + petList.get(i).getAdopter_id());
            System.out.print("\n----------------------------------------------------------------------------\n");
        }
    }
}
