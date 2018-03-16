/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author student
 */
public class TraceOrder {
    
    private int id,itemID,qty;
    private String customerID,custName,ItemName,date;
    private double total;

    public TraceOrder(int id, int itemID, int qty, String customerID, String custName, String ItemName, String date, double total) {
        this.id = id;
        this.itemID = itemID;
        this.qty = qty;
        this.customerID = customerID;
        this.custName = custName;
        this.ItemName = ItemName;
        this.date = date;
        this.total = total;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }  
}
