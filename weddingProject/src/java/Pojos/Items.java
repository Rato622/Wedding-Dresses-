/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pojos;

/**
 *
 * @author user
 */
public class Items 
{ 
    private int itemID;
    private String type;
    private String color;
    private double price;
    private String size;
    
    private int quantity;
    private String imagePath;
  
    public Items() 
    {
    }
   
   public Items(int itemID,String type,String color,int quantity,String size,double price,String imagePath) 
    {
        this.itemID = itemID;
        this.type = type;
        this.color = color;
        this.quantity = quantity;
       this.size = size;
        this.price = price;
        this.imagePath=imagePath;
        
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    
    
    
    
}
