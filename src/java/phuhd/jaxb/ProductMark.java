
package phuhd.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SingleCore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MultiCore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProductMarkID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "singleCore",
    "multiCore"
})
@XmlRootElement(name = "ProductMark", namespace = "www.PhuHDShop.ProductMark.com")
public class ProductMark {

    @XmlElement(name = "SingleCore", namespace = "www.PhuHDShop.ProductMark.com")
    protected int singleCore;
    @XmlElement(name = "MultiCore", namespace = "www.PhuHDShop.ProductMark.com")
    protected int multiCore;
    @XmlAttribute(name = "ProductMarkID", required = true)
    protected int productMarkID;

    /**
     * Gets the value of the singleCore property.
     * 
     */
    public int getSingleCore() {
        return singleCore;
    }

    /**
     * Sets the value of the singleCore property.
     * 
     */
    public void setSingleCore(int value) {
        this.singleCore = value;
    }

    /**
     * Gets the value of the multiCore property.
     * 
     */
    public int getMultiCore() {
        return multiCore;
    }

    /**
     * Sets the value of the multiCore property.
     * 
     */
    public void setMultiCore(int value) {
        this.multiCore = value;
    }

    /**
     * Gets the value of the productMarkID property.
     * 
     */
    public int getProductMarkID() {
        return productMarkID;
    }

    /**
     * Sets the value of the productMarkID property.
     * 
     */
    public void setProductMarkID(int value) {
        this.productMarkID = value;
    }

}
