/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author trinh
 */
public class Utility {

    public static int getInputChoice(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        do {
            System.out.print(msg);
            try {
                int n = Integer.parseInt(sc.nextLine());
                //Check if it is within the allowable range
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("Enter 0 or 1");
                }

            } catch (NumberFormatException e) {
                System.err.println("Enter 0 or 1");;
            }
        } while (true);
    }

    public static String getStringByRegex(String msg, String err, String Patt) {
        String s;
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        do {
            System.out.print(msg);
            s = sc.nextLine();
            //check if match
            if (Pattern.matches(Patt, s)) {
                return s;
            } else {
                System.err.print(err);
            }

        } while (true);
    }
}
