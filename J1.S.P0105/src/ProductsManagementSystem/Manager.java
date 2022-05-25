/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author trinh
 */
public class Manager {

    public static int getChoice() {
        int choice = Utility.getInputInt("Your choice: ", 1, 5, false);
        return choice;
    }

    public static void addStoreKeeper(ArrayList<StoreKeeper> listStoreKeepers) {
        while (true) {

            String storeKeeperName = Utility.getInputString("Enter storekeeper name: ", false);

            //check storekeeperName exist or not
            if (!checkStoreKeeperExist(listStoreKeepers, storeKeeperName)) {
                listStoreKeepers.add(new StoreKeeper(
                        listStoreKeepers.size() + 1, storeKeeperName));
            } else {
                System.out.println("Duplicate storekeeper!");
            }

            //check user want to continue or not
            if (!Utility.getInputYesNo("Do you want to continue (Y/N)? ", false)) {
                break;
            }
        }
        displayStoreKeeperList(listStoreKeepers);
    }

    public static boolean checkStoreKeeperExist(ArrayList<StoreKeeper> listStoreKeepers, String storeKeeperName) {
        //run from the first to last the list
        for (StoreKeeper storeKeeper : listStoreKeepers) {
            //check input storeKeeperName equal storeKeeperName in list or not
            if (storeKeeper.getStoreKeeperName().equals(storeKeeperName)) {
                return true;
            }
        }
        return false;
    }

    public static void addProduct(ArrayList<Product> listProduct, ArrayList<StoreKeeper> listStoreKeepers) {
        // check list empty or not
        if (listStoreKeepers.isEmpty()) {
            System.out.println("List StoreKeeper empty");
            return;
        }
        // run when the user enters correct
        while (true) {
            String id = Utility.getInputString("Enter ID product: ", false);
            //check product exist or not
            if (getPosition(listProduct, id) == -1) {
                Product product = getProduct(listProduct, listStoreKeepers, id, false);
                listProduct.add(product);
                break;
            } else {
                System.out.println("Duplicate ID!");
            }
        }
        displayListProduct("List product: ", listProduct);

    }

    public static void updateProduct(ArrayList<Product> listProduct, ArrayList<StoreKeeper> listStoreKeepers) {
        //check list empty or not
        if (listProduct.isEmpty()) {
            System.out.println("List empty!");
            return;
        }

        displayListProduct("List product: ", listProduct);
        String id = Utility.getInputString("Enter ID product to update: ", false);
        int position = getPosition(listProduct, id);
        //check product exist or not
        if (position != -1) {
            String idUp;
            do {
                idUp = Utility.getInputString("Update ID: ", false);
                //check idUp exist or not
                if (getPosition(listProduct, idUp) == -1) {
                    break;
                } else {
                    System.out.println("Duplicate!");
                }
            } while (true);

            System.out.println("Leave the you don't want to update blank");
            listProduct.get(position).setProductID(idUp);
            Product product = getProduct(listProduct, listStoreKeepers, idUp, true);

            //check sequence each attribute of product is empty(null) or not
            if (!checkAttributeEmpty(product.getProductName())) {
                listProduct.get(position).setProductName(product.getProductName());
            }
            if (!checkAttributeEmpty(product.getLocation())) {
                listProduct.get(position).setLocation(product.getLocation());
            }
            if (!checkAttributeEmpty(product.getCategory())) {
                listProduct.get(position).setCategory(product.getCategory());
            }
            if (!checkAttributeEmpty(product.getStoreKeeper().getStoreKeeperID() + "")) {
                listProduct.get(position).setStoreKeeper(product.getStoreKeeper());
            }
            if (product.getPrice() != 0) {
                listProduct.get(position).setPrice(product.getPrice());
            }
            if (!checkAttributeNull(product.getDateOfManufacture())) {
                listProduct.get(position).setDateOfManufacture(product.getDateOfManufacture());
            }
            if (!checkAttributeNull(product.getExpiryDate())) {
                listProduct.get(position).setExpiryDate(product.getExpiryDate());
            }
            if (!checkAttributeNull(product.getReceiptDate())) {
                listProduct.get(position).setReceiptDate(product.getReceiptDate());
            }
            displayListProduct("List product: ", listProduct);
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    public static void searchProduct(ArrayList<Product> listProduct) {
        //check list empty or not
        if (listProduct.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        Menu.displaySearchMenu();
        int choice = Utility.getInputInt("You want to search by: ", 1, 4, false);
        switch (choice) {
            //search by name
            case 1:
                String name = Utility.getInputString("Enter product name to search: ", false);
                searchByAttribute(listProduct, name);
                break;
            //search by category
            case 2:
                String category = Utility.getInputString("Enter product category to search: ", false);
                searchByAttribute(listProduct, category);
                break;
            //search by storekeeper
            case 3:
                String storekeeper = Utility.getInputString("Enter storekeeper to search: ", false);
                searchByAttribute(listProduct, storekeeper);
                break;
            //search by receiptdate
            case 4:
                Date receiptDate = Utility.getReceiptDateToSearch("Enter receipt date to search: ", false);
                searchByReceiptDate(listProduct, receiptDate);
                break;
        }
    }

    public static void sortProductList(ArrayList<Product> listProduct) {
        //check list empty or not
        if (listProduct.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product t, Product t1) {
                return t.getDateOfManufacture().compareTo(t1.getDateOfManufacture());
            }
        });
        displayListProduct("After sort: ", listProduct);
    }

    public static void searchByAttribute(ArrayList<Product> listProduct, String attribute) {

        ArrayList<Product> listResult = new ArrayList<>();
        //run from firt to last the list
        for (Product product : listProduct) {
            //check input attribut is productName or category or storekeeper
            if (product.getProductName().equalsIgnoreCase(attribute)
                    || product.getCategory().equalsIgnoreCase(attribute)
                    || product.getStoreKeeper().getStoreKeeperName().equalsIgnoreCase(attribute)) {
                listResult.add(product);
            }
        }
        //check list result empty or not
        if (listResult.isEmpty()) {
            System.out.println("Can't find product!");
        } else {
            displayListProduct("Search result: ", listResult);
        }
    }

    public static void searchByReceiptDate(ArrayList<Product> listProduct, Date receiptDate) {
        ArrayList<Product> listResult = new ArrayList<>();

        //loop runs from the beginning to the last element in the list
        for (int i = 0; i < listProduct.size(); i++) {
            //check input receiptdate match with product's receiptdate or not
            if (listProduct.get(i).getReceiptDate().equals(receiptDate)) {
                listResult.add(listProduct.get(i));
            }
        }
        //check list empty or not
        if (listResult.isEmpty()) {
            System.out.println("Can't find product with this receipt date!");
        } else {
            displayListProduct("Search result: ", listResult);
        }
    }

    public static Product getProduct(ArrayList<Product> listProduct, ArrayList<StoreKeeper> listStoreKeeper, String id, boolean isEmpty) {
        String name = Utility.getInputString("Enter name product: ", isEmpty);
        String location = Utility.getInputString("Enter location product: ", isEmpty);
        String category = Utility.getInputString("Enter category product: ", isEmpty);
        Double price = Utility.getInputDouble("Enter price's product: ", 0, Double.MAX_VALUE, isEmpty);

        Date dateOfManu = Utility.getInputDate("Enter date of manufacture product: ", null, isEmpty);
        //check isEmpty and dateOfManu null or not
        if (isEmpty && dateOfManu == null) {
            dateOfManu = listProduct.get(getPosition(listProduct, id)).getDateOfManufacture();
        }

        Date expiryDate = Utility.getInputDate("Enter expirydate product: ", dateOfManu, isEmpty);
        //check isEmpty and expiryDate null or not
        if (isEmpty && expiryDate == null) {
            expiryDate = listProduct.get(getPosition(listProduct, id)).getExpiryDate();
        }

        Date receiptDate = Utility.getInputReceiptDate("Enter receipt date of product: ", dateOfManu, expiryDate, isEmpty);
        //check isEmpty and receiptDate null or not
        if (isEmpty && receiptDate == null) {
            receiptDate = listProduct.get(getPosition(listProduct, id)).getReceiptDate();
        }

        displayStoreKeeperList(listStoreKeeper);
        int storekeeper = Utility.getStoreKeeper(listStoreKeeper, "Choose storeKeeper: ", isEmpty);
        StoreKeeper s = null;
        //check isEmpty and storekeeper empty or not
        if (isEmpty) {
            s = listProduct.get(getPosition(listProduct, id)).getStoreKeeper();
        } else {
            for (StoreKeeper st : listStoreKeeper) {
                if (st.getStoreKeeperID() == storekeeper) {
                    s = st;
                    break;
                }
            }
        }
        Product product = new Product(id, name, location, category,
                s, price, expiryDate, dateOfManu, receiptDate);
        return product;
    }

    public static void displayListProduct(String msg, ArrayList<Product> listProduct) {
        System.out.println(msg);
        System.out.format("\t%-10s %-10s %-10s %-15s %-15s %-15s %-15s %-25s %-15s\n",
                "ID", "Name", "Location", "Category", "Storekeeper", "Price",
                "Expiry Date", "Date of Manufacture", "Receipt Date");
        //run from first to last the list
        for (Product product : listProduct) {
            System.out.println(product);
        }
    }

    public static void displayStoreKeeperList(ArrayList<StoreKeeper> listStoreKeeper) {
        System.out.println("List storekeeper: ");
        System.out.format("    %s\t%s\n", "StoreKeeperID", "StoreKeeperName");
        //run from first to last the list
        for (StoreKeeper storeKeeper : listStoreKeeper) {
            System.out.print(storeKeeper);
        }
    }

    public static int getPosition(ArrayList<Product> listProduct, String id) {
        //traverse all element in list product from first to last
        for (int i = 0; i < listProduct.size(); i++) {
            //check input id equal with product id of product in listProduct or not
            if (listProduct.get(i).getProductID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean checkAttributeNull(Date attribute) {
        return attribute == null;
    }

    public static boolean checkAttributeEmpty(String attribute) {
        return attribute.equals("");
    }
}
