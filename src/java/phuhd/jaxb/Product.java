
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
 *         &lt;element name="Branch" type="{www.PhuHDShop.Product.com}Branch"/>
 *         &lt;element name="Type" type="{www.PhuHDShop.Product.com}Type"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateCreated" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Img" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{www.PhuHDShop.ProductDetail.com}ProductDetail"/>
 *         &lt;element ref="{www.PhuHDShop.ProductMark.com}ProductMark"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProductID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ProductDetailID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ProductMarkID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="IsDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "branch",
    "type",
    "price",
    "name",
    "dateCreated",
    "img",
    "productDetail",
    "productMark"
})
@XmlRootElement(name = "Product", namespace = "www.PhuHDShop.Product.com")
public class Product {

    @XmlElement(name = "Branch", namespace = "www.PhuHDShop.Product.com", required = true)
    protected Branch branch;
    @XmlElement(name = "Type", namespace = "www.PhuHDShop.Product.com", required = true)
    protected Type type;
    @XmlElement(name = "Price", namespace = "www.PhuHDShop.Product.com")
    protected long price;
    @XmlElement(name = "Name", namespace = "www.PhuHDShop.Product.com", required = true)
    protected String name;
    @XmlElement(name = "DateCreated", namespace = "www.PhuHDShop.Product.com", required = true)
    protected String dateCreated;
    @XmlElement(name = "Img", namespace = "www.PhuHDShop.Product.com", required = true)
    protected String img;
    @XmlElement(name = "ProductDetail", required = true)
    protected ProductDetail productDetail;
    @XmlElement(name = "ProductMark", namespace = "www.PhuHDShop.ProductMark.com", required = true)
    protected ProductMark productMark;
    @XmlAttribute(name = "ProductID", required = true)
    protected int productID;
    @XmlAttribute(name = "ProductDetailID", required = true)
    protected int productDetailID;
    @XmlAttribute(name = "ProductMarkID", required = true)
    protected int productMarkID;
    @XmlAttribute(name = "IsDelete")
    protected Boolean isDelete;

    /**
     * Gets the value of the branch property.
     * 
     * @return
     *     possible object is
     *     {@link Branch }
     *     
     */
    public Branch getBranch() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Branch }
     *     
     */
    public void setBranch(Branch value) {
        this.branch = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public long getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(long value) {
        this.price = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateCreated(String value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the img property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImg() {
        return img;
    }

    /**
     * Sets the value of the img property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImg(String value) {
        this.img = value;
    }

    /**
     * Gets the value of the productDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ProductDetail }
     *     
     */
    public ProductDetail getProductDetail() {
        return productDetail;
    }

    /**
     * Sets the value of the productDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductDetail }
     *     
     */
    public void setProductDetail(ProductDetail value) {
        this.productDetail = value;
    }

    /**
     * Gets the value of the productMark property.
     * 
     * @return
     *     possible object is
     *     {@link ProductMark }
     *     
     */
    public ProductMark getProductMark() {
        return productMark;
    }

    /**
     * Sets the value of the productMark property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductMark }
     *     
     */
    public void setProductMark(ProductMark value) {
        this.productMark = value;
    }

    /**
     * Gets the value of the productID property.
     * 
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the value of the productID property.
     * 
     */
    public void setProductID(int value) {
        this.productID = value;
    }

    /**
     * Gets the value of the productDetailID property.
     * 
     */
    public int getProductDetailID() {
        return productDetailID;
    }

    /**
     * Sets the value of the productDetailID property.
     * 
     */
    public void setProductDetailID(int value) {
        this.productDetailID = value;
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

    /**
     * Gets the value of the isDelete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDelete() {
        return isDelete;
    }

    /**
     * Sets the value of the isDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDelete(Boolean value) {
        this.isDelete = value;
    }

}
