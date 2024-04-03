package com.app.model;

public interface QueryConstant {
    
    String CREATE_ACCOUNT = "Insert into tblusers(users_username, users_password, users_fName, users_lName, users_mobile) " 
                    + "values (?, ?, ?, ?, ?)";
    String LOGIN_ACCOUNT = "Select * from tblusers where users_username = ? and users_password = ?";
    String UPDATE_ACCOUNT = "Update tblusers set type_name = ? where users_id = ?";
    
    String AD_PENDING_ADOPTIONS = "Select * from tblpets where adopter_id = ?";
    String AD_PET_TYPES = "Select * from tblpets where pet_type = ? and adopter_id is NULL";
    String AD_UPDATE_TO_FOR_ADOPTION = "Update tblpets set pet_status = ?, adopter_id = NULL where pet_id = ?";
    String AD_UPDATE_TO_PENDING = "Update tblpets set adopter_id = ?, pet_status = ? where pet_id = ?";
    
    String RH_PENDING_ADOPTIONS = "Select * from tblpets where owner_id = ? and pet_status = 'FOR ADOPTION'";
    String RH_CREATE_PET_PROFILE = "INSERT INTO tblpets (pet_name, pet_age, pet_breed, pet_prevState, pet_status, adopter_id, owner_id, pet_type) VALUES (?, ?, ?, ?, 'FOR ADOPTION', NULL, ?, ?)";
    String RH_UPDATE_TO_ARCHIVED = "Update tblpets set pet_status = ? where pet_id = ?";
    String RH_UPDATE_TO_APPROVED = "Update tblpets set pet_status = ? where pet_id = ?";
}
