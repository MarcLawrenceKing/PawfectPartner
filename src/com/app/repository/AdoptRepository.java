package com.app.repository;

import java.util.ArrayList;

import com.app.model.Account;
import com.app.model.Pets;

public interface AdoptRepository {
    public ArrayList<Pets> adPendingAdoptions(Pets pet);
    public ArrayList<Pets> adPetTypes(Account account, int choice);
    public void ADUpdateToFOR_ADOPTION(Pets pet);
    public void ADUpdateToPENDING(Pets pet, Account account);
}
