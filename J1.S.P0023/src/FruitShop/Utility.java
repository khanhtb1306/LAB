/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class Utility {

    public static int getInt(String msg, String err, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                //check condition
                if (result < min || result > max) {
                    System.out.println("Please input number in rage [" + min + ", " + max + "]");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    public static double getDouble(String msg, String err, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double result;
        //loop until user input correct
        while (true) {
            System.out.print(msg);
            try {
                result = Double.parseDouble(sc.nextLine());
                //check condition
                if (result <= min || result > max) {
                    System.out.println("Please input number in rage [" + min + ", " + max + "]");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    public static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print(msg);
            str = sc.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println("Not empty");
                continue;
            }
            return str;
        }
    }

    public static boolean yesOrNo(String msg) {
        String choose;
        do {
            choose = getString(msg);
        } while (!"YN".contains(choose.toUpperCase()));
        return "Y".equalsIgnoreCase(choose);
    }

    public static String getInputID(List<Fruit> list, String message) {
        //loop until user input correct
        while (true) {
            //check string by regex
            String ID = getString(message);
            ////check duplicate checkcheck
            if (!checkDupId(list, ID)) {
                System.err.println("The id existed.");
                continue;
            }
            return ID;
        }
    }

    public static boolean checkDupId(List<Fruit> list, String ID) {
        //run the first to the end list
        for (Fruit emp : list) {
            //case-insensitive comparison
            if (emp.getId().equalsIgnoreCase(ID)) {
                return false;
            }
        }
        return true;
    }

    public static String getID(List<Fruit> list, String message) {
        //loop until user input correct
        while (true) {
            String ID = getString(message);
            //check duplicate check
            if (checkDupId(list, ID)) {
                System.err.println("The id not exist.");
                continue;
            }
            return ID;
        }
    }

}
