/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLET;

import Dao.RegisterDAO;
import Dao.TraceOrder;
import Dao.WeddDAO;
import Pojos.Items;
import Pojos.Register;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class checkOutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        RequestDispatcher dispatcher=null;
        if(session!=null)
        {
            try {
                List shopCart=(List) session.getAttribute("shopcart");
                WeddDAO wd=new WeddDAO();
                if(shopCart!=null)
                {
                    double total=0.0;
                    for(int i=0;i<shopCart.size();i++)
                    {
                        Items it=(Items) shopCart.get(i);
                        total=it.getQuantity()*it.getPrice();
                    }
                    String accountNumber=request.getParameter("AcctNumber");
                    String type=request.getParameter("Type");
                    if(accountNumber.isEmpty() && type.isEmpty())
                    {
                        request.setAttribute("error", "Please enter Account number and select type.");
                        dispatcher=request.getRequestDispatcher("Transaction.jsp");
                        dispatcher.forward(request, response);
                    }else
                    {
                        DecimalFormat dec=new DecimalFormat("0.00");
                        Date date=new Date();
                        DateFormat de=new SimpleDateFormat("DD/MM/YYYY hh:mm:ss");
                        String strDate=de.format(date);
                        String message=wd.account("", accountNumber, type, total);
                       
                        Register reg=(Register) session.getAttribute("userDetails");
                        if(message.equalsIgnoreCase("Payment was successfully."))
                         {
                              for(int i=0;i<shopCart.size();i++)
                            {
                                Items it=(Items) shopCart.get(i);
                                double tot=it.getQuantity()*it.getPrice();
                                TraceOrder tr=new TraceOrder(0, it.getItemID(),it.getQuantity(), reg.getClientId(),
                                        reg.getName(), it.getType(), strDate, tot);
                                wd.insertOrder(tr);
                            }
                               request.setAttribute("error", message);
                        dispatcher=request.getRequestDispatcher("Payment.jsp");
                        dispatcher.forward(request, response); 
                         }
                        else
                        {
                             request.setAttribute("error", message);
                        dispatcher=request.getRequestDispatcher("Transaction.jsp");
                        dispatcher.forward(request, response);
                        }
                    }
                }
            } catch (Exception ex) {
               request.setAttribute("error", ex.getMessage());
            dispatcher=request.getRequestDispatcher("clientErrors.jsp");
            dispatcher.forward(request, response);
            }
        }else
        {
             request.setAttribute("error", "Shopping cart session has expired.");
            dispatcher=request.getRequestDispatcher("clientErrors.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
