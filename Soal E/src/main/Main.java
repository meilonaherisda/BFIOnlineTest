/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.Scanner;
import static main.Mask.mask;

/**
 *
 * @author meilona
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.err.print("Input kata : ");
       String input = sc.nextLine();
       String test = mask(input);
       System.out.println("Output : "+test);
    }
    
}
