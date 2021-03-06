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
import phuhd.entity.TblProductDetail;
import phuhd.entity.TblProduct;
import phuhd.entity.TblProductMark;
import phuhd.jaxb.ProductMark;

/**
 *
 * @author Duy Phu
 */
@WebServlet(name = "ShowProductDetailServlet", urlPatterns = {"/ShowProductDetailServlet"})
public class ShowProductDetailServlet extends HttpServlet {
    private final String PRODUCT_DETAIL = "productDetail.jsp";

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
            System.out.println("ID : " + id);
            if (id != null) {
                ProductDAO dao = ProductDAO.getInstance();
                TblProduct product = dao.getProductById(Integer.parseInt(id));
                if (product != null) {
                    request.setAttribute("PRODUCT", product);
                    //Get ProductDetail
                    ProductDetailDAO dtDao = ProductDetailDAO.getInstance();
                    TblProductDetail detail = dtDao.getProductDetail(Integer.parseInt(id));
                    if (detail != null) {
                        request.setAttribute("PRODUCTDETAIL", detail);
                    }
                    //Get ProductMark
                    ProductMarkDAO markDao = ProductMarkDAO.getInstance();
                    TblProductMark mark = markDao.getMarkProductByProductId(Integer.parseInt(id));
                    if(mark != null){
                        request.setAttribute("PRODUCTMARK",mark);
                    }
                }
            }
            request.getRequestDispatcher(PRODUCT_DETAIL).forward(request, response);            
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
