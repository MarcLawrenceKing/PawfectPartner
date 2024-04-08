/**
 * The Main class contains the entry point for the application.
 *
 * @author Alessa Estaras, Cassidy Fernandez, Randy Kapangyarihan, Marc King, Jhanna Llovit
 *
 * @version 04/08/2024
 */
package com.app.pawfect;

import com.app.view.DisplayHomePage;

/**
 * Main method to start the system. Calling and displaying the DisplayHomePage.
*/
public class Main {
    public static void main(String[] args) {    
        DisplayHomePage dh = new DisplayHomePage(); 
        
        dh.displayHomePage();

    }
}
