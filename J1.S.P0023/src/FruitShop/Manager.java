/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author trinh
 */
public class Manager {

    public static void displayMenu() {
        System.out.println("\n========Fruit Shop System========\n"
                + "1. Create Fruit\n"
                + "2. View orders\n"
                + "3. Shopping (for buyer)\n"
                + "4. Exit");
    }

    public static int Choice() {
        int choice = Utility.getInt("Input choice: ", "Choice invalid", 1, 4);
        return choice;
    }


    //Create Fruit
    public static void createFruit(List<Fruit> listFruit) {
        //loop until user don't want to create fruit
        while (true) {
            
            String id = Utility.getInputID(listFruit, "Fruit Id: ");
            String name = Utility.getString("Fruit name: ");
            double price = Utility.getDouble("Price: ", "Price invalid!", 0, 1000);
            int quantity = Utility.getInt("Quantity: ", "Quantity invalid!", 1, 1000);
            String origin = Utility.getString("Origin: ");
   
            listFruit.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Add successfully.");
            
            if (!Utility.yesOrNo("Do you want add new fruit? (Y/N) -> ")) {
                break;
            }
        }
    }
    
    //view bill
    public void viewBill(Hashtable<String, Order> listBill) {
        // check list bull empty or not
        if (listBill.isEmpty()) {
            System.out.println("No order to view");
            return;
        }
        //run from start to finish listbill by key
        for (String name : listBill.keySet()) {
            System.out.println("Customer: " + name.substring(0, name.indexOf(" (")));
            displayOrder(listBill.get(name));
            System.out.println();
        }
    }
    

    //shopping
    public void shopping(List<Fruit> listFruit, Hashtable<String, Order> listBill ) {
        //check list fruit empty or not
        if (listFruit.isEmpty()) {
            System.out.println("No Fruit to buy");
            return;
        }
        displayFruits(listFruit);
        // create order
        Order order = new Order();
        //run until the user wants to stop 
        while (true) {
            String id = Utility.getID(listFruit, "Enter the ID fruit: ");
            
            //Get the fruit the user entered by id and print the name of that fruit
            Fruit fruit = getFruit(listFruit, id);
            System.out.println("You selected: " + fruit.getName());
            
            //Get the quantity of that fruit in the order 
            int quantityFromListOrder = order.getQuantityFromListOrder(fruit);
            int quantity = Utility.getInt("Please input quantity: ", "Input invalid", 0, fruit.getQuantity() - quantityFromListOrder  );
            
            //add fruit to order
            order.addFruit(fruit, quantity);
            
            //stop if the user doesn't want to continue 
            if (!Utility.yesOrNo("Do you want to continue? (Y/N) -> ")) {
                break;
            }
        }
        displayOrder(order);
        order.setOrderName(Utility.getString("Input your name: "));
        addOrderToListBill(order.getOrderName() + " (" + new Date() + ")", order, listFruit, listBill);
        System.out.println("Successful purchase!!!");
    }

    public void addOrderToListBill(String CusName, Order order, List<Fruit> listFruit, Hashtable<String, Order> listBill) {
        listBill.put(CusName, order);
        // update list Fuit
        updateListFruit(order.getListOrder(), listFruit);
    }
    
    // update list Fruit 
    public void updateListFruit(List<Fruit> list, List<Fruit> listFruit) {
        //run from the beginning to the end of the list
        for (Fruit order : list) {
            Fruit fruit = getFruit(listFruit, order.getId());
            fruit.setQuantity(fruit.getQuantity() - order.getQuantity());
            //check quantity is 0 or not
            if (fruit.getQuantity() == 0) {
                listFruit.remove(fruit);
            }
        }
    }

    public Fruit getFruit(List<Fruit> listFruit, String id) {
        //run from the beginning to the end of the list
        for (Fruit fruit : listFruit) {
            //check if the current id is equal to the id in the list
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }


    public void displayOrder(Order order) {
        System.out.println("Product | Quantity | Price | Amount");
        int i = 1;
        double sum = 0;
        //run from the beginning to the end the list
        for (Fruit fruit : order.getListOrder()) {
            System.out.printf("%d.%-8s   %-5d   %4.1f$   %4.1f$\n",
                    i++,
                    fruit.getName(),
                    fruit.getQuantity(),
                    fruit.getPrice(),
                    fruit.getQuantity() * fruit.getPrice());
            sum += fruit.getQuantity() * fruit.getPrice();
        }
        System.out.printf("Total: %4.1f$\n", sum);
    }

    public void displayFruits(List<Fruit> listFruit) {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ | ++ Quantity ++ |");
        //run from the first to the last the list
        listFruit.forEach((fruit) -> {
            System.out.printf("      %-7s      %-10s\t    %-8s\t     %2.1f$\t     %d\n",
                    fruit.getId(), fruit.getName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity());
        });
    }

}
