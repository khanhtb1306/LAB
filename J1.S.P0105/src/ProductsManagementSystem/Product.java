/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductsManagementSystem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author trinh
 */
public class Product {
    private String productID, productName, location, category;
    private Double price;
    private Date ExpiryDate,dateOfManufacture, ReceiptDate;
    private StoreKeeper storeKeeper;

    public Product(String ID, String name, String location, String category, StoreKeeper storeKeeper, Double price, Date ExpiryDate, Date dateOfManufacture, Date ReceiptDate) {
        this.productID = ID;
        this.productName = name;
        this.location = location;
        this.category = category;
        this.storeKeeper = storeKeeper;
        this.price = price;
        this.ExpiryDate = ExpiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.ReceiptDate= ReceiptDate;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public StoreKeeper getStoreKeeper() {
        return storeKeeper;
    }

    public void setStoreKeeper(StoreKeeper storeKeeper) {
        this.storeKeeper = storeKeeper;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(Date ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        return String.format("\t%-7s %-13s %-10s %-15s %-15s %-15s %-18s %-23s %-10s", productID,productName,location,category,storeKeeper.getStoreKeeperName(),price, dateFormat.format(ExpiryDate),dateFormat.format(dateOfManufacture), dateFormat.format(ReceiptDate));
    }
}
