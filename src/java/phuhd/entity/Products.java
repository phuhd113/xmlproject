/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Duy Phu
 */
@XmlRootElement(name ="products")
public class Products implements Serializable{
    private List<TblProduct> products;

    public void setProducts(List<TblProduct> products) {
        this.products = products;
    }

    @XmlElement(name = "cpu")
    public List<TblProduct> getProducts() {
        if(products == null){
            products = new ArrayList<>();
        }
        return products;
    }    
}
