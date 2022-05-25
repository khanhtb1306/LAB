/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managerr;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author trinh
 */
public class GetInput {

    //check user input int
    public static int getInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                //check the condition is within a range
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            String result = scanner.nextLine().trim();
            // check the result is empty or not
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input string code
    public static String getStringByRegex() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            try {
                String result = scanner.nextLine().trim();
                //describes what is being searched for.
                Pattern p = Pattern.compile("[^a-zA-Z]");

                // check the result is empty or not
                if (result.isEmpty()) {
                    System.out.println("Not empty");
                    System.out.print("Enter again: ");
                }else{
                //Check if it is matcher
                if (p.matcher(result).find()) {
                    throw new Exception();
                } else {
                    return result;
                }
                }
            } catch (Exception e) {
                System.out.println("Do not enter special characters");
                System.out.println("as (!@#$%&*()_+=|<>?{}\\\\[\\\\]~-) and number");
                System.out.println("Enter again:");
            }
        }
    }

    //check user input double limit
    public static float getFloat() {
        Scanner scanner = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                float result = Float.parseFloat(scanner.nextLine());
                if (result > 0 && result <= Integer.MAX_VALUE) {
                    return result;
                } else {
                    System.out.println("Out of range, Please enter a number greater than 0 ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number float");
                System.out.print("Enter again: ");
            }
        }
    }
}
