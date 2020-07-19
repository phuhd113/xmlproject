/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.servlet;

import java.util.List;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import phuhd.dao.ProductDAO;
import phuhd.entity.TblProduct;
import phuhd.uitls.XJCGenerateJavaObj;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuhd.entity.Products;

/**
 *
 * @author Duy Phu
 */
public class RequestServletListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        String button = request.getParameter("btAction");
        if (button == null) {
            String page = request.getParameter("page");
            List<TblProduct> listProduct = null;
            if (page == null) {
                listProduct = ProductDAO.getInstance().getProducts();
                int countProduct = listProduct.size();
                int pageSize = (countProduct / 20);
                if ((pageSize * 20) < countProduct) {
                    pageSize = pageSize + 1;
                }
                if (pageSize != 0) {
                    sre.getServletRequest().setAttribute("PAGESIZE", pageSize);
                    // Set list Product
                    Products products = new Products();
                    products.setProducts(listProduct.subList(0, 20));
                    String strXML = XJCGenerateJavaObj.marshalData(products);
                    sre.getServletRequest().setAttribute("PRODUCTS", strXML);
                }
            } else {
                listProduct = ProductDAO.getInstance().getProducts();
                int countProduct = listProduct.size();
                int pageSize = (countProduct / 20);
                if ((pageSize * 20) < countProduct) {
                    pageSize = pageSize + 1;
                }
                if (pageSize != 0) {
                    sre.getServletRequest().setAttribute("PAGESIZE", pageSize);
                    // Set list Product
                    Products products = new Products();
                    int end = Integer.parseInt(page) * 20;
                    if (end < countProduct) {
                        int begin = end - 20;
                        products.setProducts(listProduct.subList(begin, end));
                        String strXML = XJCGenerateJavaObj.marshalData(products);
                        sre.getServletRequest().setAttribute("PRODUCTS", strXML);
                    } else {
                        products.setProducts(listProduct.subList((end - 20), countProduct));
                        String strXML = XJCGenerateJavaObj.marshalData(products);
                        sre.getServletRequest().setAttribute("PRODUCTS", strXML);
                    }
                }
            }
        }

    }

}
