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

/**
 *
 * @author Duy Phu
 */
@WebServlet(name = "ProcessServlet", urlPatterns = {"/ProcessServlet"})
public class ProcessServlet extends HttpServlet {

    private final String SHOW_DETAIL_SERVLET = "ShowProductDetailServlet";
    private final String SEARCH_NAME_SERVLET = "SearchByNameServlet";
    private final String COMPARE_PRODUCT_SERVLET = "CompareProductServlet";
    private final String COMPARE_PRODUCT_DETAIL_SERVLET = "CompareProductDetailServlet";
    private final String CHOOSE_PRODUCT_SERVLET = "ChooseProductServlet";
    private final String FILTER_PRODUCT_SERVLET = "FilterProductServlet";
    private final String SELECTED_PRODUCT_SERVLET = "SelectedProductServlet";

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
        String url = "";
        try {
            String button = request.getParameter("btAction");
            if (button.equals("Chi tiết")) {
                url = SHOW_DETAIL_SERVLET;
            }else if(button.equals("Tìm kiếm")){
                url =SEARCH_NAME_SERVLET;
            }else if(button.equals("So sánh")){
                url =COMPARE_PRODUCT_SERVLET;
            }else if(button.equals("So Sánh")){
                url = COMPARE_PRODUCT_DETAIL_SERVLET;
            }else if(button.equals("Chọn sản phẩm")){
                url = CHOOSE_PRODUCT_SERVLET;
            }else if(button.equals("TÌM KIẾM")){
                url = FILTER_PRODUCT_SERVLET;
            }else if(button.equals("Chọn")){
                url = SELECTED_PRODUCT_SERVLET;
            }
        } catch (Exception e) {
            log("ProcessServlet : " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
