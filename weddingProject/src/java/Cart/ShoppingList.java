/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Cart;

import java.util.Vector;
import Pojos.Items;

/**
 *
 * @author user
 */
public class ShoppingList {
    private Vector<Items> vecItem;

    public ShoppingList(Vector<Items> vecItem) {
        this.vecItem = vecItem;
    }
    public Vector<Items> getItems()
    {
        return vecItem;
    }
    public void add(Items item)
    {
        vecItem.add(item);
    }
    public void remove(int itemId)
    {
        for(Items item:vecItem)
        {
            if(itemId==item.getItemID())
            {
                vecItem.remove(item);
            }
        }
    }
    
}
