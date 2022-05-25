/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FruitShop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author trinh
 */
public class Order {
   
    private String OrderName;
    private List<Fruit> listOrder;
    
    
    public Order() {
        this.listOrder = new ArrayList<>();
    }

    public Order(String OrderName, List<Fruit> listOrder) {
        this.OrderName = OrderName;
        this.listOrder = listOrder;
        
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String OrderName) {
        this.OrderName = OrderName;
    }

    public List<Fruit> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Fruit> listOrder) {
        this.listOrder = listOrder;
    }

    public void addFruit(Fruit fruit, int quantity) {
        //check quantity = 0 or not
        if (quantity == 0) {
            return;
        }
        //run from first to last the list 
        for (Fruit fr : listOrder) {
            if (fr.getId().equalsIgnoreCase(fruit.getId())) {
                fr.setQuantity(fr.getQuantity() + quantity);
                return;
            }
        }
        listOrder.add(new Fruit(fruit.getId(), fruit.getName(), fruit.getPrice(), quantity, fruit.getOrigin()));
    }


    public int getQuantityFromListOrder(Fruit fruit) {
        for (Fruit fr : listOrder) {
            //check equals or not
            if (fr.getId().equalsIgnoreCase(fruit.getId())) {
                return fr.getQuantity();
            }
        }
        return 0;
    }
}
