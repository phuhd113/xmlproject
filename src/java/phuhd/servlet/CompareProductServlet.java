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
@WebServlet(name = "CompareProductServlet", urlPatterns = {"/CompareProductServlet"})
public class CompareProductServlet extends HttpServlet {
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
            String id = request.getParameter("idValue");
            ProductDAO dao = ProductDAO.getInstance();
            TblProduct product = dao.getProductById(Integer.parseInt(id));
            if(product != null){
                HttpSession session = request.getSession();
                TblProduct product1 = (TblProduct) session.getAttribute("PRODUCT_1");
                TblProduct product2 = (TblProduct) session.getAttribute("PRODUCT_2");
                if(product1 == null){
                    session.setAttribute("PRODUCT_1", product);
                }
                if(product1 != null && product2 == null){
                    session.setAttribute("PRODUCT_2", product);
                }
                if(product1 != null && product2 != null){
                    session.setAttribute("PRODUCT_2", product);
                }                              
            }
            request.getRequestDispatcher(COMPARE_PAGE).forward(request, response);
        }finally{
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
