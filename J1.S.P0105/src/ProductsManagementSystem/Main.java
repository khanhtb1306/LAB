/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsManagementSystem;
import java.util.ArrayList;

/**
 *
 * @author trinh
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Product> listProduct = new ArrayList<>();
        ArrayList<StoreKeeper> listStoreKeeper = new ArrayList<>();

        //loop allow user choose option until want to exit
        while (true) {
            //Step1. display menu 
            Menu.displayMainMenu();
            //Step2. get user's choice
            int choice = Manager.getChoice();

            switch (choice) {
                case 1:
                    //Step3. add storekeeper
                    Manager.addStoreKeeper(listStoreKeeper);
                    break;
                case 2:
                    //Step4. add product
                    Manager.addProduct(listProduct, listStoreKeeper);
                    break;
                case 3:
                    //Step5. update information of product
                    Manager.updateProduct(listProduct, listStoreKeeper);
                    break;
                case 4:
                    //Step6. search product
                    Manager.searchProduct(listProduct);
                    break;
                case 5:
                    //Step7. sort list of product
                    Manager.sortProductList(listProduct);
                    break;
                case 6:
                    //Step8. exits
                    break;
            }
        }
    }
}
