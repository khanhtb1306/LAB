/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managerr;
import java.util.ArrayList;

/**
 *
 * @author trinh
 */
public class ManageGeographic {

    public static void main(String[] args) {

        ArrayList<EastAsiaCountries> listCountry = new ArrayList<>();
        
        //loop until user want to exit the program
        while (true) {

            //step1:display menu
            ManageEastAsiaCountries.displayMenu();

            //step2: Ask the use to choice
            int userChoice = ManageEastAsiaCountries.askTheUseToChoice();

            switch (userChoice) {
                case 1:
                    //step 3: Enter information of countries 
                    ManageEastAsiaCountries.enterTheInformationForCountries(listCountry);
                    break;
                case 2:
                    //step 4: Display already information.
                    ManageEastAsiaCountries.displayAlreadyInformation(listCountry);
                    break;
                case 3:
                    //step 5: Search country by name
                    ManageEastAsiaCountries.searchCountryByName(listCountry);
                    break;
                case 4:
                    //step 6: Display sort by name countries
                    ManageEastAsiaCountries.displaySortByNameCountry(listCountry);
                    break;
                case 5:
                    //step7: Exist 
                    System.exit(0);
            }
        }
    }
}
