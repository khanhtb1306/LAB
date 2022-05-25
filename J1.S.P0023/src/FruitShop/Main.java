/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


/**
 *
 * @author trinh
 */
public class Main {
    public static void main(String[] args) {
        Hashtable<String, Order> listBill = new Hashtable<>();
        List<Fruit> listFruit = new ArrayList<>();
        Manager Manager = new Manager();

        while (true) {
            //Step 1: Display menu
            Manager.displayMenu();
            //Step 2: Choice opption
            int choice = Manager.Choice();
            switch (choice) {
                case 1:
                    //Step 3: Create fruit
                    Manager.createFruit(listFruit);
                    break;
                case 2:
                    //Step 4: View bill
                    Manager.viewBill(listBill);
                    break;
                case 3:
                    //Step 5: shopping
                    Manager.shopping(listFruit, listBill);
                    break;
                case 4:
                    //Step 6: exit program
                    System.exit(0);
            }
        }
    }    
}

