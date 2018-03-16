/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLET;

import Pojos.Items;
import Pojos.Register;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfAppearance;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dineopc
 */
public class printInvoiceServlet extends HttpServlet {

    ServletOutputStream sOut;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OutputStream file = null;

        try {

            HttpSession session=request.getSession(true);
            if(session!=null)
            {
              
                    sOut = response.getOutputStream();
                    file = new FileOutputStream(new File("D:\\invoice.pdf"));
                    Document document = new Document();
                    HeaderFooter hf = new HeaderFooter(new Phrase("Zazu's wedding dresses"), false);
                    PdfWriter write = PdfWriter.getInstance(document, file);
                    PdfWriter wr=PdfWriter.getInstance(document, response.getOutputStream());
                    hf.setBackgroundColor(Color.GREEN);
                    hf.setAlignment(PdfAppearance.ALIGN_CENTER);
                    hf.setBorder(PdfNumber.STRING);
                    document.setHeader(hf);
                    document.open();
                    Table table = new Table(3, 100);
                    table.setSpacing(1);
                     Cell cell1 = new Cell("Dress Type");
                    cell1.setBackgroundColor(Color.WHITE);
                    Cell cell2 = new Cell("Quantity");
                    cell2.setBackgroundColor(Color.WHITE);
                    Cell cell3 = new Cell("Cost");
                    cell3.setBackgroundColor(Color.WHITE);
                     Cell cell4 = new Cell("Size");
                    cell4.setBackgroundColor(Color.WHITE);
                    table.addCell(cell1);
                    table.addCell(cell4);
                    table.addCell(cell2);
                    table.addCell(cell3);
                    double total=0;
                    double pr=0;
                   List shopCart=(List) session.getAttribute("shopcart");
                  
                   DecimalFormat dec=new DecimalFormat("0.00");
                   for(int i=0;i<shopCart.size();i++)
                   {
                       Items prod=(Items) shopCart.get(i);
                       table.addCell(prod.getType());
                      table.addCell(prod.getSize());
                       table.addCell(""+prod.getQuantity());
                       pr=prod.getPrice()*prod.getQuantity();
                       table.addCell("R "+dec.format(pr));
                       total+=pr;
                   }
                    table.addCell("===================");
                   table.addCell("===================");
                    table.addCell("===================");

                    table.addCell("Total");
                    table.addCell("**************");
                    table.setBackgroundColor(Color.WHITE);
                    table.addCell("R "+total);
                    table.setBackgroundColor(Color.WHITE);
                    Paragraph subTitle = new Paragraph("*************INVOICE********************");
                    subTitle.setAlignment(PdfAppearance.ALIGN_CENTER);
                    document.add(subTitle);

                    document.add(new Paragraph(" "));
                   Register reg=(Register) session.getAttribute("userDetails");
                   String data="Address:"+reg.getAddress()+"\nEmail :"+reg.getEmail();
                    Paragraph address=new Paragraph(data);
                    address.setAlignment(PdfAppearance.ALIGN_LEFT);
                    document.add(address);
                    
                    String order=(String) session.getAttribute("orderN");
                    Paragraph orderNumber=new Paragraph("Order no:"+order);
                    document.add(orderNumber);
                    
                    Paragraph p1 = new Paragraph("Thank you for shopping.");
                    Paragraph p2 = new Paragraph("Enjoy your day!!!");
                    p1.setAlignment(PdfAppearance.ALIGN_CENTER);
                    p2.setAlignment(PdfAppearance.ALIGN_CENTER);
                    document.add(table);
                    document.add(p1);
                    document.add(p2);
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph("******************************************* END OF REPORT ********************************************"));
                    document.add(new Paragraph("Generated on: " + new Date().toString()));

                    HttpSession session1=request.getSession();
                    session1.invalidate();
                    document.close();
                    file.close();
            }
        }  catch (IOException ex) {
            Logger.getLogger(printInvoiceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(printInvoiceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(printInvoiceServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

