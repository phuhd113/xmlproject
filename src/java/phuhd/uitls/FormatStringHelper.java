/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.uitls;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import phuhd.entity.TblProduct;
import phuhd.jaxb.Branch;
import phuhd.jaxb.Product;
import phuhd.jaxb.Type;

/**
 *
 * @author Duy Phu
 */
public class FormatStringHelper {

    public FormatStringHelper() {
    }

    public void formatNameCPU(String fullname, TblProduct product) {
        if (!fullname.isEmpty()) {
            product.setName(fullname);
            // set Branch
            if (fullname.contains(Branch.INTEL.value())) {
                product.setBranch(Branch.INTEL.value());
            } else {
                product.setBranch(Branch.AMD.value());
            }
            // set Type
            for (Type myType : Type.values()) {
                if (fullname.toUpperCase().contains(myType.value().toUpperCase())) {
                    product.setType(myType.value());
                    break;
                }
            }
            //set CreateDate
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String frmtdDate = formatter.format(date);
            product.setDateCreated(date);
            product.setIsDelete(Boolean.FALSE);

        }
    }

    public long formatPrice(String price) {
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(price);
        String tmp = "";
        while (matcher.find()) {
            tmp += matcher.group();
        }
        if (!tmp.isEmpty()) {
            return Long.parseLong(tmp);
        }
        return 0;
    }
    public String formatCodeCPU(String nameCPU){
        String regex = "[A-Z]{0,2}[0-9]{4,7}[A-Z]{0,2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameCPU);
        String name ="";
        if(matcher.find()){
            name += matcher.group();
        }
        return name;
    }
    
    public String formatProductDetail(String detail){
        String regex = "[0-9.]{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(detail);
        String tmp ="";
        if(matcher.find()){
            tmp += matcher.group();
        }
        return tmp;
    }

}
