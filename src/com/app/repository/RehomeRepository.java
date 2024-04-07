
package com.app.repository;

import java.util.ArrayList;

import com.app.model.Pets;

public interface RehomeRepository {
    public ArrayList<Pets> rhPendingAdoptions(Pets pet);
    public void RHUpdateToAPPROVED(Pets pet);
    public void RHUpdateToNOTAPPROVED(Pets pet);
    public void RHUpdateToARCHIVED(Pets pet);    
    public void rhPetProfiles(Pets pet);

}
