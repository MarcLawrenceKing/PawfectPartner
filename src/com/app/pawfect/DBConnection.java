/*
    the DBConnection class provides methods to establish and manage database connections
    it uses JDBC to interact with the MySQL database
    provides a centralized location for managing database connections and operations throughout the system
    
    @author Alessa Estaras, Cassidy Fernandez, Kapangyarihan Randy, Marc King, Jhanna Llovit
    @version 04/06/2023
*/
package com.app.pawfect;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

    // database connection parameters
    private final static String URL = "jdbc:mysql://localhost:3306/db_pawfect";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    // database connection objects
    protected static Connection con;
    protected static PreparedStatement prep;
    protected Statement state;
    protected static ResultSet result;

    /*
        establishes a connection to the MySQL database
        this method loads the MySQL JDBC driver and creates a connection to the specific database

        @exception ClassNotFoundException if the JDBC driver class is not found
        @exception SQLException is a database access error occurs
    */
    public static void connect() {
        try {
            Class.forName(DRIVER); // load the MySQL JDBC driver
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD); // create a connection to the database
        } catch (Exception e) {
            System.err.println(e); // print any exceptions that occur during connection
        }
    }
}
