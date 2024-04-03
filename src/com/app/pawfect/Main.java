
package com.app.pawfect;

import com.app.view.DisplayHomePage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        DisplayHomePage dh = new DisplayHomePage();
        
        dh.displayHomePage(sc);
        
    }
}
