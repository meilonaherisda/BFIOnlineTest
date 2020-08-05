/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author meilona
 *
 */
public class Mask {

    public static String mask(String original) {
        String a = original;
        String b[] = a.split(" ");
        List<String> newMask = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            String s = b[i];
            if (s.length() > 2) {
                char first = s.charAt(0);
                char last = s.charAt(s.length() - 1);
                String sbMask = s.substring(1, s.length() - 1);
                String masking = sbMask.replaceAll(".", "*");
                String newString = first + masking + last;
                newMask.add(newString);
            } else {
                newMask.add(s);
            }
        }

        return newMask.toString().replace(",", "").replace("[","").replace("]", "");
    }

}
