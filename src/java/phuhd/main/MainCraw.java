/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import phuhd.dao.ProductDAO;
import phuhd.entity.Products;
import phuhd.entity.TblProduct;
import phuhd.parser.StAXParser;
import phuhd.uitls.FormatStringHelper;
import phuhd.uitls.StringHelper;
import phuhd.uitls.XJCGenerateJavaObj;

/**
 *
 * @author Duy Phu
 */
public class MainCraw {
    public static void main(String[] args) throws IOException, UnsupportedEncodingException, XMLStreamException {
        StAXParser parser = new StAXParser();
        StringHelper stringHelper = new StringHelper();
        FormatStringHelper format = new FormatStringHelper();
        //String doc = stringHelper.getHTMLCPUByPage("https://nguyencongpc.vn/cpu-bo-vi-xu-ly?page=1");
        //String doc = stringHelper.getPageSizeOfCategory("https://nguyencongpc.vn/cpu-bo-vi-xu-ly?page=1");
        //String doc = stringHelper.getHTMLOfCPUIntelDetail("https://nguyencongpc.vn/cpu-intel-core-i7-10700t-20ghz-turbo-45ghz-8-nhan-16-luong-16mb-cache");
        //String doc = stringHelper.getHTMLOfDetailProduct("https://hoanghapc.vn/cpu-intel-core-i7-10700k");
        //parser.stAXParserProductDetail(doc);
        //parser.stAXParserPageSize(doc);
        //parser.stAXParserCPUsByPage(doc);
        String doc = stringHelper.getHTMLOfDetailProduct("https://www.cpu-monkey.com/en/cpu-intel_core_i9_9900ks-950");
        //parser.stAXParserCpuBenchMark(doc);
        //System.out.println(format.formatCodeCPU("CPU Intel Xeon E5-2696 v2 / 2.5GHz / 30MB / 12 Core / 24 Thread / Socket 2011"));
        parser.stAXParserProductDetail(doc);
        //System.out.println(doc);
        
    }
    private void TestMarsher(){
        XJCGenerateJavaObj generateJavaObj = new XJCGenerateJavaObj();
        ProductDAO dao =new ProductDAO();
        //generateJavaObj.generateObj();
        List<TblProduct> products = dao.getProducts();
        Products tmp = new Products();
        tmp.setProducts(products);
        String str = generateJavaObj.marshalData(tmp);
        System.out.println(str);
    }
}
