/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Pojos.Register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class RegisterDAO 
{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public RegisterDAO() throws ClassNotFoundException ,SQLException
    {
        ConnectToDB c=new ConnectToDB();
        connection = c.DBConnect();
        statement = connection.createStatement();
    }
    public int registerClient(String clientId,String name, String surname,int age,String gender, String cellNo,String email,String address) throws SQLException
    {
        
        String sql = "insert into tblClient(ClientID,name,surname,age,gender,cellNo,email,address) values('"+clientId+"'"+name+"','"+surname+"',"
                +" "+age+",'"+gender+"','"+cellNo+"','"+address+")";
        return statement.executeUpdate(sql);
    } 
    
    public Register getClientInfo(String id) throws SQLException
    {
        String sql="Select * from  tblClient where ClientID='"+id+"'";
        Register reg=null;
        resultSet=statement.executeQuery(sql);
        while(resultSet.next())
        {
            reg=new Register(resultSet.getString("ClientID"),resultSet.getString("name") , resultSet.getString("surname")
                    , resultSet.getInt("age"), resultSet.getString("gender"), resultSet.getString("cellNo"), resultSet.getString("email")
                    , resultSet.getString("address"));
        }
        return  reg;
    }
    public void close() throws SQLException
    {
        statement.close();
        connection.close();
    }
    
    public static void main(String[] args)
    {
        try {
            RegisterDAO r=new RegisterDAO();
            Register rr=r.getClientInfo("12345678901234");
            System.out.print(rr.getName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
