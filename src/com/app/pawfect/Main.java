/*
    The main class is the entry point of the Pawfect system
    it initializes the important components and starts the system by displaying the home page 
    this class also contains the main method

    @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit

    @version 04/06/2024
*/
package com.app.pawfect;

import com.app.view.DisplayHomePage;
import java.util.Scanner;

public class Main {
    /*
        the entry point of the system initializes the components needed and starts the system
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // initialize a Scanner object to retrieve user input       
        DisplayHomePage dh = new DisplayHomePage(); // create an instance of DisplayHomePage
        
        dh.displayHomePage(sc); // display the home page of the system
        
    }
}
