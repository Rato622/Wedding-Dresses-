/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Pojos.Login;

/**
 *
 * @author user
 */
public class LoginDAO 
{
    private Statement statement;
    private Connection connection;

    public LoginDAO() throws ClassNotFoundException,SQLException
    {
       ConnectToDB c=new ConnectToDB();
        connection = c.DBConnect();
       
        statement = connection.createStatement();
        
    }
    public Login logon(String userName,String password) throws SQLException
    {
        String sql = "select * from tblLogin where username='"+userName+"'and password='"+password+"'";
        Login logon=null;
        ResultSet st = statement.executeQuery(sql);
        if(st.next())
        {
            logon = new Login(st.getString(1),st.getString(2),st.getString(3),st.getString(4));
            
        }
        return logon;
    }
    public void close() throws SQLException
    {
        statement.close();
        connection.close();
    }
    
}
