/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuhd.dao.ProductDAO;
import phuhd.dao.ProductDetailDAO;
import phuhd.entity.TblProduct;
import phuhd.entity.TblProductDetail;

/**
 *
 * @author Duy Phu
 */
@WebServlet(name = "FilterProductServlet", urlPatterns = {"/FilterProductServlet"})
public class FilterProductServlet extends HttpServlet {
private final String SEARCH_PAGE = "search.jsp";
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
            String branch = request.getParameter("branch");
            String type = request.getParameter("typeCPU");
            System.out.println("Filter Servlet : "+type);
            String core = request.getParameter("core");
            String thread = request.getParameter("thread");
            String socket = request.getParameter("socket");
            String memory = request.getParameter("memory");
            String overClocking = request.getParameter("overClocking");
            // Set boolean overClocking
            String tmpOverClocking = overClocking;
            if(overClocking.equals("Có")){
                tmpOverClocking = "1";
            }
            if(overClocking.equals("Không")){
                tmpOverClocking = "0";
            }
            
            //Filter ProductDetail
            ProductDetailDAO dtDao = ProductDetailDAO.getInstance();           
            List<TblProductDetail> listDetail =dtDao.filterProduct(core, thread, memory, socket, tmpOverClocking);
            //Filter Product
            ProductDAO dao = ProductDAO.getInstance();
            List<TblProduct> listProduct = dao.filterProduct(branch, type);

            // Map 2 list
            List<TblProduct> listTmp = new ArrayList<>();

            for (int i = 0; i < listDetail.size(); i++) {
                for (int j = 0; j < listProduct.size(); j++) {
                    if(listDetail.get(i).getProductID() == listProduct.get(j).getId()){
                        listTmp.add(listProduct.get(j));
                        break;
                    }
                }
            }           
            if(listTmp!= null){
                request.setAttribute("RESULT", listTmp);
            }       
            request.getRequestDispatcher("ChooseProductServlet").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
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
