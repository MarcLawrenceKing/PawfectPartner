package com.app.repository;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;

public interface AdminRepository {
    public void logInAccountAdmin (Account account);
    public ArrayList<Account> ADMUsersTable();
    public ArrayList<Pets> ADMPetsTable ();
    public void ADMDeltePetsArchived ();

}
