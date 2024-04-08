/**
 * The query constant interface contains all the query constants used in the database,
 * it provides a centralized location to store SQL queries used throughout,
 * This interface groups related queries together for better organization and maintenance
 *
 * This interface should be implemented by classes that need to use these query constants.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *   
 * @version 04/07/2024
 */
package com.app.model;

public interface QueryConstant {

    // database connection parameters
    final static String URL = "jdbc:mysql://localhost:3306/db_pawfect";
    final static String USERNAME = "root";
    final static String PASSWORD = "";
    final static String DRIVER = "com.mysql.jdbc.Driver";

    // Queries for user accounts
    String CREATE_ACCOUNT = "Insert into tblusers(users_username, users_password, users_fName, users_lName, users_mobile) " 
                    + "values (?, ?, ?, ?, ?)";
    String LOGIN_ACCOUNT = "Select * from tblusers where users_username = ? and users_password = ?";
    String UPDATE_ACCOUNT = "Update tblusers set type_name = ? where users_id = ?";

    // Queries for administrator accounts
    String LOGIN_ACCOUNT_ADMIN = "Select * from tblusers where users_username = ? and users_password = ?";
    String ADM_USERS_TABLE = "Select * from tblusers";
    String ADM_PETS_TABLE = "Select * from tblpets";
    String ADM_ARCHIVED_PETS_TABLE = "Select * from tblpets where pet_status = 'ARCHIVED'";    
    String ADM_DELETE_PETS = "Delete from tblpets where pet_id = ?";
    String ADM_RETRIEVE_PETS_ARCHIVED = "Update tblpets set pet_status = 'FOR ADOPTION' where pet_id = ?";

    // Queries for adoption
    String AD_PENDING_ADOPTIONS = "Select * from tblpets where adopter_id = ? and pet_status = 'PENDING'";
    String AD_PET_TYPES = "Select * from tblpets where pet_type = ? and not pet_status = 'ARCHIVED'  and adopter_id is NULL and(owner_id <> ? or owner_id is NULL)";
    String AD_UPDATE_TO_FOR_ADOPTION = "Update tblpets set pet_status = ?, adopter_id = NULL where pet_id = ?";
    String AD_UPDATE_TO_PENDING = "Update tblpets set adopter_id = ?, pet_status = ? where pet_id = ?";

    // Queries for pet owners/owners that will rehome their pets 
    String RH_PENDING_ADOPTIONS = "Select * from tblpets where owner_id = ? and (pet_status = 'FOR ADOPTION' or pet_status = 'PENDING')";
    String RH_CREATE_PET_PROFILE = "INSERT INTO tblpets (pet_name, pet_age, pet_breed, pet_prevState, pet_status, adopter_id, owner_id, pet_type) VALUES (?, ?, ?, ?, 'FOR ADOPTION', NULL, ?, ?)";
    String RH_UPDATE_TO_ARCHIVED = "Update tblpets set pet_status = ? where pet_id = ?";
    String RH_UPDATE_TO_APPROVED = "Update tblpets set pet_status = ? where pet_id = ?";
    String RH_UPDATE_TO_NOT_APPROVED = "Update tblpets set pet_status = ? where pet_id = ?";
}
