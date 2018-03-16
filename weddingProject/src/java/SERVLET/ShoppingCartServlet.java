/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLET;

import Dao.WeddDAO;
import Pojos.Items;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       HttpSession session=request.getSession(true);
       if(session!=null)
       {
            List shopCart=(List) session.getAttribute("shopcart");
            session.setAttribute("shopcart", shopCart);
           response.sendRedirect("shoppingCart.jsp");
       }else
       {
           List shopCart=null;
            session.setAttribute("shopcart", shopCart);
           response.sendRedirect("shoppingCart.jsp");
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       HttpSession session=request.getSession(true);
       String decision=request.getParameter("decision");
       String[] ids=request.getParameterValues("itemIds");
        RequestDispatcher dispatcher=null;
       if(session!=null)
       {
            try {
                List shopCart=(List) session.getAttribute("shopcart");
                WeddDAO wd=new WeddDAO();
                if(decision.equalsIgnoreCase("Add to cart"))
                {
                    int id=Integer.parseInt(request.getParameter("itemID"));
                    int quantity=Integer.parseInt(request.getParameter("txtQuantity"));
                    if(shopCart==null)
                    {
                        shopCart=new ArrayList();
                        Items it=wd.getItem(id);
                        if(it.getQuantity()>0 && quantity<=it.getQuantity())
                        {
                            it.setQuantity(quantity);
                            shopCart.add(it);
                            session.setAttribute("shopcart", shopCart);
                            response.sendRedirect("client.jsp");
                        }else
                        {
                             request.setAttribute("error", "only "+it.getQuantity());
                            dispatcher=request.getRequestDispatcher("clientErrors.jsp");
                            dispatcher.forward(request, response);
                        }
                        
                    }else
                    {
                          Items it=wd.getItem(id);
                        if(it.getQuantity()>0 && quantity<=it.getQuantity())
                        {
                            it.setQuantity(quantity);
                            shopCart.add(it);
                            session.setAttribute("shopcart", shopCart);
                            response.sendRedirect("client.jsp");
                        }else
                        {
                             request.setAttribute("error", "only "+it.getQuantity());
                            dispatcher=request.getRequestDispatcher("clientErrors.jsp");
                            dispatcher.forward(request, response);
                        } 
                    }
                    
                }else if(decision.equalsIgnoreCase("Remove from cart"))
                {
                    if(ids!=null)
                    {
                        Items item=null;
                        for(int i=0;i<ids.length;i++)
                        {
                            for(int x=0;x<shopCart.size();x++)
                            {
                               item=(Items) shopCart.get(x);
                               int id=Integer.parseInt(ids[i]);
                               if(id==item.getItemID())
                               {
                                   shopCart.remove(x);
                               }
                               
                            }
                        }
                         session.setAttribute("shopcart", shopCart);
                            response.sendRedirect("shoppingCart.jsp");
                    }else
                    {
                      request.setAttribute("error", "Select item to remove.");
                            dispatcher=request.getRequestDispatcher("shoppingCart.jsp");
                            dispatcher.forward(request, response);   
                    }
                }else if(decision.equalsIgnoreCase(decision))
                {
                    session.setAttribute("shopcart", shopCart);
                            response.sendRedirect("Transaction.jsp");
                }
            
            } catch (ClassNotFoundException ex) {
                request.setAttribute("error", ex.getMessage());
            dispatcher=request.getRequestDispatcher("clientErrors.jsp");
            dispatcher.forward(request, response);
            } catch (SQLException ex) {
                 request.setAttribute("error", ex.getMessage());
            dispatcher=request.getRequestDispatcher("clientErrors.jsp");
            dispatcher.forward(request, response);
            }
       }
        
    }

}
