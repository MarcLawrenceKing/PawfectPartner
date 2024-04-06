/*
    the query constant interface contains all the query constants used in the database
    it provides a centralized location to store SQL queries used throughout
    this interface groups related queries together for better organization and maintenance

    This interface should be implemented by classes that need to use these query constants.

    @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
  
    @version 04/06/2024
*/
package com.app.model;
/*
    an interface that contains all the query constants used in the database operations
*/

public interface QueryConstant {

    // SQL query to create a new user account
    String CREATE_ACCOUNT = "Insert into tblusers(users_username, users_password, users_fName, users_lName, users_mobile) " 
                    + "values (?, ?, ?, ?, ?)";
    // SQL query to log in to an existing user account, checks if the details of the users are present in the database 
    String LOGIN_ACCOUNT = "Select * from tblusers where users_username = ? and users_password = ?";
    // SQL query to update user's account type
    String UPDATE_ACCOUNT = "Update tblusers set type_name = ? where users_id = ?";

    // SQL query to log in to an admin account
    String LOGIN_ACCOUNT_ADMIN = "Select * from tblusers where users_username = ? and users_password = ?";
    // SQL query to retrieve all users table data for admin usage
    String ADM_USERS_TABLE = "Select * from tblusers";
    // SQL query to retrieve all pets table data for admin usage
    String ADM_PETS_TABLE = "Select * from tblpets";
    // SQL query to delete archives pets for admin
    String ADM_DELETE_PETS_ARCHIVED = "Delete from tblpets where pet_status = 'ARCHIVED'";

    // SQL query to retrieve pending adoptions for the adopter user
    String AD_PENDING_ADOPTIONS = "Select * from tblpets where adopter_id = ?";
    // SQL query to retrieve pets of specific type that is available for adoption
    String AD_PET_TYPES = "Select * from tblpets where pet_type = ? and adopter_id is NULL";
    // SQL query to update the adoption status of the pet to Approved or Rejected
    String AD_UPDATE_TO_FOR_ADOPTION = "Update tblpets set pet_status = ?, adopter_id = NULL where pet_id = ?";
    // SQL query to update the adoption status of the pet to Pending Adoption
    String AD_UPDATE_TO_PENDING = "Update tblpets set adopter_id = ?, pet_status = ? where pet_id = ?";

    // SQL query to retrieve pending adoptions for the users that will rehome their pet
    String RH_PENDING_ADOPTIONS = "Select * from tblpets where owner_id = ? and pet_status = 'FOR ADOPTION'";
    // SQL query to create a new pet profile 
    String RH_CREATE_PET_PROFILE = "INSERT INTO tblpets (pet_name, pet_age, pet_breed, pet_prevState, pet_status, adopter_id, owner_id, pet_type) VALUES (?, ?, ?, ?, 'FOR ADOPTION', NULL, ?, ?)";
    // SQL query to update pet status to archived
    String RH_UPDATE_TO_ARCHIVED = "Update tblpets set pet_status = ? where pet_id = ?";
    // SQL query to update pet status to approved
    String RH_UPDATE_TO_APPROVED = "Update tblpets set pet_status = ? where pet_id = ?";
}
