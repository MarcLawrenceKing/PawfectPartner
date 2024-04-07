package com.app.repository;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;

public interface AdminRepository {
    public void logInAccountAdmin (Account account);
    public ArrayList<Account> admUsersTable();
    public ArrayList<Pets> admPetsTable ();
    public ArrayList<Pets> admArchivedPetsTable ();
    public void admDeletePets(int choice);
    public void admRetrievePetsArchived (int choice);

}
