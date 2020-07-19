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
import phuhd.dao.ProductDetailDAO;
import phuhd.dao.ProductMarkDAO;
import phuhd.entity.TblProduct;
import phuhd.entity.TblProductDetail;
import phuhd.entity.TblProductMark;
import phuhd.jaxb.ProductDetail;
import phuhd.main.AppConstant;
import phuhd.parser.StAXParser;
import phuhd.uitls.FormatStringHelper;
import phuhd.uitls.StringHelper;

/**
 *
 * @author Duy Phu
 */
public class CPUMonkeyCrawler {

    public static void main(String[] args) {

        crawlCPUDetail();
    }

    private static void crawlMark() {
        StringHelper stringHelper = new StringHelper();

        try {
            String doc = stringHelper.getHTMLOfCPUMark(AppConstant.URL_CPU_MARK_ONE_CORE);
            if (!doc.isEmpty()) {
                StAXParser parser = new StAXParser();
                List<TblProductMark> productMarks = parser.stAXParserCpuBenchMark(doc);
                if (productMarks.size() != 0) {
                    for (TblProductMark productMark : productMarks) {
                        ProductMarkDAO.getInstance().saveMarkWhenCrawling(productMark);
                    }
                    System.out.println("Done");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void crawlCPUDetail() {
        List<TblProduct> listProduct = ProductDAO.getInstance().getProducts();
        try {
            if (listProduct != null) {
                StringHelper helper = new StringHelper();
                FormatStringHelper stringHelper = new FormatStringHelper();
                StAXParser parser = new StAXParser();
                List<TblProductMark> listProductMark = ProductMarkDAO.getInstance().getAll();
                for (TblProduct tblProduct : listProduct) {
                    String cpuCode = stringHelper.formatCodeCPU(tblProduct.getName());
                    if (!cpuCode.isEmpty()) {
                        for (TblProductMark tblProductMark : listProductMark) {
                            if (stringHelper.formatCodeCPU(tblProductMark.getName()).equals(cpuCode)) {
                                //Update ProductID on ProductMark table
                                ProductMarkDAO.getInstance().updateProductID(tblProductMark.getId(), tblProduct.getId());
                                //Insert productDetail
                                String url = tblProductMark.getUrl();                                
                                String doc = helper.getHTMLOfDetailProduct(url);
                                if (doc != null) {
                                    TblProductDetail detail = parser.stAXParserProductDetail(doc);
                                    //set ProductID
                                    detail.setProductID(tblProduct.getId());
                                    ProductDetailDAO.getInstance().saveProductDetail(detail);  
                                    System.out.println("Done : "+tblProductMark.getName());
                                }
                                break;
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (XMLStreamException e){
            e.printStackTrace();
        }
    }
}
