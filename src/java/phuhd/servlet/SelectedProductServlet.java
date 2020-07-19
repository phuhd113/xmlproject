/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuhd.dao.ProductDAO;
import phuhd.entity.TblProduct;

/**
 *
 * @author Duy Phu
 */
@WebServlet(name = "SelectedProductServlet", urlPatterns = {"/SelectedProductServlet"})
public class SelectedProductServlet extends HttpServlet {

    private final String COMPARE_PAGE = "compare.jsp";

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
        try {
            String productId = request.getParameter("productId");
            ProductDAO dao = ProductDAO.getInstance();
            TblProduct product = dao.getProductById(Integer.parseInt(productId));

            // Get session product1 ,product2 , productSelected
            HttpSession session = request.getSession();
            String productSelected = (String) session.getAttribute("ProductSelected");
            System.out.println("Selected Servlet : " + productSelected);
            if (productSelected == null) {
                session.setAttribute("PRODUCT_1", product);
            } else {
                if (productSelected.equals("1")) {
                    session.setAttribute("PRODUCT_1", product);
                }
                if (productSelected.equals("2")) {
                    session.setAttribute("PRODUCT_2", product);
                }
            }

            request.getRequestDispatcher(COMPARE_PAGE).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
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
