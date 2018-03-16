/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import Dao.LoginDAO;
import Dao.RegisterDAO;
import Dao.WeddDAO;
import Pojos.Login;
import Pojos.Register;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

    RequestDispatcher dispatcher
            =null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter(); 
            HttpSession session=request.getSession();
            LoginDAO lg=new LoginDAO();
            RegisterDAO regDao=new RegisterDAO();
            String username=request.getParameter("username");
            String password=request.getParameter("password");
           if(username.isEmpty() && password.isEmpty())
           {
               request.setAttribute("error", "Please enter username and password");
                dispatcher=request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
           }else
           {
               Login l=lg.logon(username, password);
               if(l!=null)
               {
                   if(l.getRole().equals("Admin"))
                   {
                       
                   }else  if(l.getRole().equals("User"))
                   {
                        WeddDAO wd=new WeddDAO();
                       session.setAttribute("products", wd.getItems());
                       Register reg=regDao.getClientInfo(l.getClientID());
                       session.setAttribute("userDetails", reg);
                       System.out.println("id"+l.getClientID());
                       response.sendRedirect("client.jsp");
                   }
               }else
               {
                   request.setAttribute("error", "User doesn't exists, please register.");
                dispatcher=request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
               }
           }
            
        } catch (ClassNotFoundException ex) {
            request.setAttribute("error", ex.getMessage());
            dispatcher=request.getRequestDispatcher("errorMessage.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
            dispatcher=request.getRequestDispatcher("errorMessage.jsp");
            dispatcher.forward(request, response);
        }
        
    }
}
