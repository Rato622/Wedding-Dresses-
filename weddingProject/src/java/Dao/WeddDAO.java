/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Pojos.Items;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class WeddDAO {
    
     private Statement statement;
    private Connection connection;
    private ResultSet result;
    
    public WeddDAO() throws ClassNotFoundException ,SQLException
    {
       ConnectToDB c=new ConnectToDB();
        connection = c.DBConnect();
        statement = connection.createStatement();
 
    }
    public int addItems(int itemID,String type,String colour,double price,int size,double  totprice,int quantity) throws SQLException
    {
        String sql ="insert into tblItems(ItemId,type,colour,price,size,quantity) values('"+type+"','"+colour+"',"+price+","+size+","+totprice+","+quantity+")";
        return  statement.executeUpdate(sql);
    }
    public int deleteItem(int itemId) throws SQLException
    {
        String sql = "delete from tblItems where itemID="+itemId;
        return statement.executeUpdate(sql);
        
    }
    public List<Items> getItems() throws SQLException
    {
        String sql = "select * from tblItems";
        result = statement.executeQuery(sql);
        List<Items> items = new ArrayList<Items>();
        
   //itemID,String type,String color,int quantity,String size,double price,String imagePath 
        while(result.next())
        {
            items.add(new Items(result.getInt("ItemId"),result.getString("type"),result.getString("colour"),
                    result.getInt("quantity"),result.getString("size"),result.getDouble("price"),result.getString("imagePath")));
        }
        return items;
    }
    public Items getItem(int itemID) throws SQLException
    {
       
        String sql ="select * from tblItems where ItemId="+ itemID;
        result =  statement.executeQuery(sql);
        Items item =null;
        while(result.next())
        {
             item=new Items(result.getInt("ItemId"),result.getString("type"),result.getString("colour"),
                    result.getInt("quantity"),result.getString("size"),result.getDouble("price"),result.getString("imagePath"));
        }
        return item;
    }
   public void searchItem(int itemID)throws SQLException
    {
        
    }
	public int insertOrder(TraceOrder order) throws SQLException
    {
        String sql="Insert into traceorder (CustomerID,CustomerName,ItemId,ItemName,Quantity,Date, Total) Values('"+
                order.getCustomerID()+"','"+order.getCustName()+"',"+order.getItemID()+",'"+order.getItemName()+"',"+
                order.getQty()+",'"+order.getDate()+"',"+order.getTotal()+")";
        
        return statement.executeUpdate(sql);
    }
        //Handling accounts
   public String account(String id,String accNumber,String type,double total) throws SQLException
    {
        String sql="SELECT * FROM accounts WHERE AccountType='"+type+"'";
        String msg="";
        result=statement.executeQuery(sql);
        boolean valid=false;
        double newBalance=0;
        while(result.next())
        {
            String act=result.getString("AccountNumber");
            if(act.equals(accNumber) && type.equals(result.getString("AccountType")))
            {
                valid=true;
                newBalance=result.getDouble("Balance")-total;
            }
        }
        if(valid==true)
        {
            String sql2="UPDATE accounts SET Balance="+newBalance+" WHERE AccountNumber='"+accNumber+"'";
            if(statement.executeUpdate(sql2)>0)
            {
                msg="Payment was successfully.";
            }
        }
        else if(valid==false)
        {
            msg="Incorrect Account number or type.";
        }
        return msg;
    }
    public void close() throws SQLException
    {
        statement.close();
        connection.close();
    }
    
    public static void main(String[] args)
    {
        try {
            WeddDAO d=new WeddDAO();
            List<Items> i=d.getItems();
            System.out.println("dress "+i.get(0).getColor());
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(WeddDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(WeddDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
