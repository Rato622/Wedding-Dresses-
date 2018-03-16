/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pojos;

import java.util.Vector;

/**
 *
 * @author user
 */
public class WeddingCat 
{
    private Vector<Items> itemVec;

    public Vector<Items> getItemVec() 
    {
        return itemVec;
    }

    public void setItemVec(Vector<Items> itemVec) 
    {
        this.itemVec = itemVec;
    }
    public void addItem(Items item)
    {
        itemVec.add(item);
    }
    public void removeItem(int itemID)
    {
        for(Items item:itemVec)
        {
            if(itemID == item.getItemID())
            {
                itemVec.remove(item);
            }
        }
    }
    
    
    
}
