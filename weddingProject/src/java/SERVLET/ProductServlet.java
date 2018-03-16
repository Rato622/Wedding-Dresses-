/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import Dao.WeddDAO;
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
public class ProductServlet extends HttpServlet {

    RequestDispatcher dispatcher
            =null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            WeddDAO wd=new WeddDAO();
            HttpSession session=request.getSession();
            session.setAttribute("products", wd.getItems());
            response.sendRedirect("Products.jsp");
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }
}
