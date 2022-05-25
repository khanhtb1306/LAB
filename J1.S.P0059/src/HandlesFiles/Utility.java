/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandlesFiles;

import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class Utility {

    public static String getInputString(String message) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            System.out.print(message);
            String result = sc.nextLine().trim();
            //check empty
            if (result.isEmpty()) {
                System.err.println("Not empty!!!");
            } else {
                return result;
            }
        }
    }

    public static int InputChoice(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                System.out.print(message);
                int result = Integer.parseInt(sc.nextLine().trim());
                //check condition
                if (result < min || result > max) {
                    System.out.println("Please input number in rage [" + min + ", " + max + "]");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input number");
            }
        }
    }

    public static double getSalary(String message) {
        //loop until user input correct
        while (true) {
            String salaryinput = getInputString(message);
            try {
                double Salary = Double.parseDouble(salaryinput);
                //condition greater than 0
                if (Salary < 0) {
                    System.err.println("Salary must be greater than 0.");
                }
                return Salary;
            } catch (NumberFormatException e) {
                System.err.println("Invalid salary.");
            }

        }
    }

    public static boolean getInputYN(String message) {
        //loop until user input correct
        while (true) {
            String result = getInputString(message);
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
        }
    }
}
