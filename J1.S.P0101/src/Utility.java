/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author trinh
 */
public class Utility {

    public static int getInputChoice(String message, int min, int max) {
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
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
            }
        }
    }
    
    public static int inputChoice(String message) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                System.out.print(message);
                int result = Integer.parseInt(sc.nextLine().trim());
                //check condition
                if (result <= 0 || result > 6) {
                    System.out.println("Please input number in rage [" + 1 + ", " + 6 + "]");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
            }
        }
    }
    
    
    public static String getInputString(String message) {
        Scanner sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            System.out.print(message);
            String result = sc.nextLine().trim();
            //check empty
            if (result.isEmpty()) {
                System.err.println("Not Empty!");
            } else {
                return result;
            }
        }
    }

    public static String getDate(String message) {
        String DatePattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DatePattern);
        dateFormat.setLenient(false);
        //loop until user input correct
        while (true) {
            String date = getInputString(message);
            try {
                Date inputDate = dateFormat.parse(date);
                //check date future
                if (!new Date().after(inputDate)) {
                    System.out.println("Input Date must before current date");
                    continue;
                }
                return date;

            } catch (ParseException e) {
                System.err.println("date follow the format dd/MM/yyyy");
            }
        }
    }

    public static String getEmail(String message) {
        // Start by every word or - + @ every word+. + every word
        String EmailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(EmailPattern);
        //loop until user input correct
        while (true) {
            String Email = getInputString(message);
            Matcher valid = pattern.matcher(Email);
            if (!valid.find()) {
                System.err.println("Invalid email.");
                continue;
            }
            return Email;
        }
    }

    public static String getSex(String message) {
        //loop until user input correct
        while (true) {
            String result = getInputString(message);
            if (result.equalsIgnoreCase("male")) {
                return result;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("female")) {
                return result;
            }
            System.err.println("Please input MALE or FEMALE.");
        }
    }

    public static double getSalary(String message) {
        //loop until user input correct
        while (true) {
            String salaryinput = getInputString(message);
            try {
                double Salary = Double.parseDouble(salaryinput);
                //check salary > 0
                if (Salary <= 0) {
                    System.out.println("Salary must be greater than 0.");
                    continue;
                }
                return Salary;
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary.");
            }

        }
    }

    public static String getPhone(String message) {
        // Start by 0 or ( and end by all number or all number and 1)         
        String PhonePattern = "^(^[0(]((\\d{1,}[)]{1}[0-9]*)|([0-9]{9,15})))$";
        Pattern pattern = Pattern.compile(PhonePattern);
        //loop until user input correct
        while (true) {
            String Phone = getInputString(message);
            Matcher valid = pattern.matcher(Phone);
            //check match or not
            if (!valid.find()) {
                System.err.println("Invalid phone number.");
                continue;
            }
            return Phone;
        }
    }


    //check user input string code
    public static String getStringByRegex(String message) {
        Scanner scanner = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            System.out.print(message);
            try {
                String result = scanner.nextLine().trim();
                //describes what is being searched for.
                Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                // check the result is empty or not
                if (result.isEmpty()) {
                    System.out.println("Not empty!!!");
                } else {
                    //Check if it is matcher
                    if (p.matcher(result).find()) {
                        throw new Exception();
                    } else {
                        return result;
                    }
                }
            } catch (Exception e) {
                System.out.println("Do not enter special characters");
                System.out.println("as (!@#$%&*()_+=|<>?{}\\\\[\\\\]~-)");
            }
        }
    }

    public static boolean checkDupId(ArrayList<Employee> list, String ID) {
        //run the first to the end list
        for (Employee emp : list) {
            //case-insensitive comparison
            if (emp.getId().equalsIgnoreCase(ID)) {
                return false;
            }
        }
        return true;
    }

    public static String getID(ArrayList<Employee> list, String message) {
        //loop until user input correct
        while (true) {
            String ID = getInputString(message);
            //check duplicate check
            if (checkDupId(list, ID)) {
                System.err.println("The id not exist.");
                continue;
            }
            return ID;
        }
    }
    
        public static String getInputID(ArrayList<Employee> list, String message) {
        //loop until user input correct
        while (true) {
            //check string by regex
            String ID = getStringByRegex(message);
            ////check duplicate checkcheck
            if (!checkDupId(list, ID)) {
                System.err.println("The id existed.");
                continue;
            }
            return ID;
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
