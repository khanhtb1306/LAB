/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managerr;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author trinh
 */
public class ManageEastAsiaCountries {

    //display menu
    public static int displayMenu() {
        System.out.println("                                            MENU                                             ");
        System.out.println("=============================================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the inforation of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("=============================================================================================");
        System.out.println("Enter your choice: ");
        return 0;
    }

    //Enter the information for countries
    public static void enterTheInformationForCountries(ArrayList<EastAsiaCountries> listCountry) {

//        listCountry.add(new EastAsiaCountries("A", "a", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("B", "b", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("C", "c", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("D", "d", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("E", "e", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("F", "f", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("G", "g", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("H", "h", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("I", "i", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("K", "k", 1, "Nice"));
//        listCountry.add(new EastAsiaCountries("L", "l", 1, "Nice"));
        //loop until user input correct
        while (true) {
            //check list not to exceed 11 countries
            if (listCountry.size() < 11) {
                System.out.println("");
                System.out.println("Enter code of country: ");
                String countryCode = GetInput.getStringByRegex();

                //check code contry exist or not
                if (duplicateCountryCode(listCountry, countryCode)) {
                    System.out.println("Country code Exist.");
                } else {

                    //loop until user input correct
                    while (true) {
                        System.out.println("Enter name of country: ");
                        String countryName = GetInput.getString();

                        //check name contry exist or not
                        if (duplicateCountryName(listCountry, countryName)) {
                            System.out.println("Country name Exist.");
                            System.out.println("");
                        } else {
                            System.out.println("Enter total Area: ");
                            float totalArea = GetInput.getFloat();

                            System.out.println("Enter terrain of country: ");
                            String countryTerrain = GetInput.getString();

                            listCountry.add(new EastAsiaCountries(countryCode,
                                    countryName, totalArea, countryTerrain));
                            System.out.println("Add successful");
                            System.out.println("");
                            return;
                        }
                    }
                }
            } else {
                System.out.println("Can not input country");
                break;
            }
        }
    }

    //Ask the use to choice
    public static int askTheUseToChoice() {
        int Choice = GetInput.getInt(1, 5);
        return Choice;
    }

    //display already information of countries
    public static void displayAlreadyInformation(ArrayList<EastAsiaCountries> listCountry) {
        //check country empty  then return
        if (listCountry.isEmpty()) {
            System.out.print("List is empty");
            System.out.println();
            return;
        }
        System.out.printf("%-10s%-20s%-25s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        //run from start to finish an arraylist
        for (EastAsiaCountries i : listCountry) {
            i.display();
            System.out.println("");

        }
    }

    //Search country by name
    public static void searchCountryByName(ArrayList<EastAsiaCountries> listCountry) {
        //check country empty 
        if (listCountry.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("");
        } else {
            //loop until user input correct
            while (true) {
                System.out.println("Enter the name you want to search for: ");
                String name = GetInput.getString();
                //run from start to finish an arraylist

                for (EastAsiaCountries i : listCountry) {
                    //non-case sensitive string comparison
                    if (i.getCountryName().equalsIgnoreCase(name)) {
                        System.out.printf("%-10s%-20s%-25s%-20s\n", "ID", "Name",
                                "Total Area", "Terrain");
                        i.display();
                        System.out.println("");
                        return;
                    } else {
                        System.out.println("Not found, please again");
                        break;
                    }
                }
            }
        }
    }

    // display sort by name country
    public static void displaySortByNameCountry(ArrayList<EastAsiaCountries> listCountry) {
        // check if arraylist is empty
        if (listCountry.isEmpty()) {
            System.out.print("List is empty");
            System.out.println();
            return;
        }
        //sort
        //run from the beginning of the list to the end of the list
        for (int i = 0; i < listCountry.size() - 1; i++) {
            /* runs from the beginning of the list to the end of the list and
              skip a last element when the outer loop grows */
            for (int j = 0; j < listCountry.size() - 1 - i; ++j) {
                //compares two strings lexicographically, case insensitive
                if (listCountry.get(j).getCountryName().compareToIgnoreCase(listCountry.get(j + 1).getCountryName()) > 0) {
                    //Swap the current element and the element after it
                    Collections.swap(listCountry, j, j + 1);
                }
            }
        }

        System.out.printf("%-10s%-20s%-25s%-20s\n", "ID", "Name", "Total", "Terrain");
        //run from start to finish an arraylist
        for (EastAsiaCountries i : listCountry) {
            i.display();
            System.out.println("");
        }
    }

    // Duplicate country code
    public static boolean duplicateCountryCode(ArrayList<EastAsiaCountries> country, String code) {
        //run from start to finish an arraylist
        for (EastAsiaCountries countrycode : country) {
            //non-case sensitive string comparison
            if (countrycode.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }

        }
        return false;
    }

    // dulicate country code
    public static boolean duplicateCountryName(ArrayList<EastAsiaCountries> country, String name) {
        //run from start to finish an arraylist
        for (EastAsiaCountries countryname : country) {
            //non-case sensitive string comparison
            if (countryname.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
