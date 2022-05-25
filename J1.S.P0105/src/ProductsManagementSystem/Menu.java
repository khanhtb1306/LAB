/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsManagementSystem;

/**
 *
 * @author trinh
 */
public class Menu {

    public static void displayMainMenu() {
        System.out.println("---------------Main menu---------------");
        System.out.println("\t1. Add Storekeeper");
        System.out.println("\t2. Add product");
        System.out.println("\t3. Update product");
        System.out.println("\t4. Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("\t5. Sort product by Date of manufacture");
        System.out.println("\t6. Exit");
    }
    public static void displaySearchMenu() {
        System.out.println("------------Search menu------------");
        System.out.println("\t1. Search by product name");
        System.out.println("\t2. Search by product category");
        System.out.println("\t3. Search by storekeeper");
        System.out.println("\t4. Search by receipt date");
    }
}
