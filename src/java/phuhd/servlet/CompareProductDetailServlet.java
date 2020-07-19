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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuhd.dao.ProductDAO;
import phuhd.dao.ProductDetailDAO;
import phuhd.dao.ProductMarkDAO;
import phuhd.entity.TblProduct;
import phuhd.entity.TblProductDetail;
import phuhd.entity.TblProductMark;
import phuhd.jaxb.ProductMark;

/**
 *
 * @author Duy Phu
 */
@WebServlet(name = "CompareProductDetailServlet", urlPatterns = {"/CompareProductDetailServlet"})
public class CompareProductDetailServlet extends HttpServlet {
private final String COMPARE_DETAIL_PAGE = "compareDetail.jsp";
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
            String idProduct_1 = request.getParameter("idProduct_1");
            String idProduct_2 = request.getParameter("idProduct_2");
            //Product 1
            if (idProduct_1 != null) {
                // Setup Product  
                ProductDAO proDao = ProductDAO.getInstance();
                TblProduct product_1 = proDao.getProductById(Integer.parseInt(idProduct_1));
                if (product_1 != null) {
                    request.setAttribute("PRODUCT_1", product_1);
                }
                //Setup Detail
                ProductDetailDAO dtDao = ProductDetailDAO.getInstance();
                TblProductDetail detail_1 = dtDao.getProductDetail(Integer.parseInt(idProduct_1));
                if (detail_1 != null) {
                    request.setAttribute("DETAIL_1", detail_1);
                }
                //Setup Mark
                ProductMarkDAO markDAO = ProductMarkDAO.getInstance();
                TblProductMark mark_1 = markDAO.getMarkProductByProductId(Integer.parseInt(idProduct_1));
                if (mark_1 != null) {
                    request.setAttribute("MARK_1", mark_1);
                }
            }
            //Product 2
            if (idProduct_2 != null) {
                // Setup Product  
                ProductDAO proDao = ProductDAO.getInstance();
                TblProduct product_2 = proDao.getProductById(Integer.parseInt(idProduct_2));
                if (product_2 != null) {
                    request.setAttribute("PRODUCT_2", product_2);
                }
                //Setup Detail
                ProductDetailDAO dtDao = ProductDetailDAO.getInstance();
                TblProductDetail detail_2 = dtDao.getProductDetail(Integer.parseInt(idProduct_2));
                if (detail_2 != null) {
                    request.setAttribute("DETAIL_2", detail_2);
                }
                //Setup Mark
                ProductMarkDAO markDAO = ProductMarkDAO.getInstance();
                TblProductMark mark_2 = markDAO.getMarkProductByProductId(Integer.parseInt(idProduct_2));
                if (mark_2 != null) {
                    request.setAttribute("MARK_2", mark_2);
                }
            }
            request.getRequestDispatcher(COMPARE_DETAIL_PAGE).forward(request, response);
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
