/**
 * The DBConnection class establishes a database connection using JDBC.
 * it uses JDBC to interact with the MySQL database and provides a centralized 
 * location for managing database connections and operations throughout the system
    
 * @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
 
 * @version 04/07/2024
 */
package com.app.pawfect;

import com.app.model.QueryConstant;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection implements QueryConstant {

    // database connection objects
    protected static Connection con;
    protected static PreparedStatement prep;
    protected Statement state;
    protected static ResultSet result;

    /**
     * Establishes a connection to the database, this method loads 
     * the MySQL JDBC driver.
     */
    public static void connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
