/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.crawler;

import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import phuhd.dao.ProductDAO;
import phuhd.entity.TblProduct;
import phuhd.main.AppConstant;
import phuhd.parser.StAXParser;
import phuhd.uitls.StringHelper;

/**
 *
 * @author Duy Phu
 */
public class NguyenCongPCCrawler {

    public static void main(String[] args) {
        StringHelper stringHelper = new StringHelper();

        try {
            String docPageSize = stringHelper.getPageSizeOfProduct(AppConstant.URL_NC_CPU);
            if (!docPageSize.isEmpty()) {
                StAXParser parser = new StAXParser();
                int pageSize = parser.stAXParserPageSize(docPageSize);
                System.out.println("Page size : " + pageSize);
                if (pageSize != 0) {
                    String docCPU = "";
                    for (int i = 0; i < pageSize; i++) {

                        docCPU = stringHelper.getHTMLCPUByPage(AppConstant.URL_NC_CPU + "?page=" + (i + 1));
                        if (!docCPU.isEmpty()) {
                            List<TblProduct> listProduct = parser.stAXParserCPUsByPage(docCPU);
                            if (listProduct.size() != 0) {
                                System.out.println("size : " + listProduct.size());
                                for (int j = 0; j < listProduct.size(); j++) {
                                    ProductDAO.getInstance().saveProductWhenCrawling(listProduct.get(j));
                                    
                                }
                            }

                        }
                        System.out.println("Done page : " + (i+1));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
