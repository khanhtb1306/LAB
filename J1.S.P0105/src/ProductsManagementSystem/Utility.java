/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsManagementSystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class Utility {

    public static String getInputString(String msg, boolean isEmpty) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty() && isEmpty) {
                return input;
            }
            //check input empty or not
            if (input.isEmpty() && !isEmpty) {
                System.out.println("Not empty!");
            } else {
                return input;
            }
        } while (true);
    }

    public static int getInputInt(String msg, int min, int max, boolean isEmpty) {
        String input;
        int result = 0;
        //loop allow user input until valid
        while (true) {
            input = getInputString(msg, isEmpty);
            if (input.isEmpty() && isEmpty) {
                return result;
            }
            try {
                result = Integer.parseInt(input);
                //check result in range [min,max] or not
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.out.printf("Please input in range [%d-%d].\n", min, max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please input digit");
            }
        }
        return result;
    }

    public static double getInputDouble(String msg, double min, double max, boolean isEmpty) {
        String input;
        double result = 0;
        //loop allow user input until valid
        while (true) {
            input = getInputString(msg, isEmpty);
            if (input.isEmpty() && isEmpty) {
                return result;
            } else {
                try {
                    result = Double.parseDouble(input);
                    //check result in range [min,max] or not
                    if (result >= min && result <= max) {
                        return result;
                    } else {
                        System.out.println("out of range");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Please input double");
                }
            }
        }

    }

    public static Date getReceiptDateToSearch(String msg, boolean isEmpty) {
        String input;
        Date date = null;
        do {
            input = getInputString(msg, isEmpty);
            if (input.isEmpty() && isEmpty) {
                break;
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                // \d{1,2}: the number have 1 or 2 digit number
                //[/]: contain character /
                //\d{4}: the number must have 4 digit
                if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                    System.out.println("Input is wrong format");
                    continue;
                }
                try {
                    date = dateFormat.parse(input);
                    break;
                } catch (ParseException pe) {
                    System.out.println("Date hasn't been existed!!");
                }
            }
        } while (true);
        return date;
    }

    public static Date getInputDate(String msg, Date dateToCompare, boolean isEmpty) {
        String input;
        Date date;
        do {
            input = getInputString(msg, isEmpty);
            if (input.isEmpty() && isEmpty) {
                return null;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            Date curDate = new Date();
            // \d{1,2}: the number have 1 or 2 digit number
            //[/]: contain character /
            //\d{4}: the number must have 4 digit
            if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                System.out.println("Input is wrong format");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                if (dateToCompare == null) {
                    if (date.after(curDate)) {
                        System.out.println("Input must be not after " + 
                                dateFormat.format(curDate));
                    } else {
                        break;
                    }
                } else {

                    if (date.before(curDate)) {
                        System.out.println("Input must after " + 
                                dateFormat.format(curDate));
                    } else {
                        break;
                    }
                }
            } catch (ParseException pe) {
                System.out.println("Date hasn't been existed!!");
            }
        } while (true);
        return date;
    }

    public static Date getInputReceiptDate(String msg, Date manuDate, 
            Date expiryDate, boolean isEmpty) {
        Date date;
        do {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            date = getReceiptDateToSearch(msg, isEmpty);
            if (date == null && isEmpty) {
                return date;
            }
            if (date.after(manuDate) && date.before(expiryDate)) {
                return date;
            } else {
                System.out.println("Input must be from " 
                        + dateFormat.format(manuDate) + " to " 
                        + dateFormat.format(expiryDate));
            }
        } while (true);

    }

    public static int getStoreKeeper(ArrayList<StoreKeeper> listStoreKeeper,String msg, boolean isEmpty) {
        int input;
        int storekeeper = 0;
        input = getInputInt(msg, 1, listStoreKeeper.size(), isEmpty);
        if (input != 0) {
            storekeeper = listStoreKeeper.get(input - 1).getStoreKeeperID();
        }
        return storekeeper;
    }

    public static boolean getInputYesNo(String msg, boolean isEmpty) {
            //loop until user input correct
        while (true) {
            String result = getInputString(msg, isEmpty);
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
