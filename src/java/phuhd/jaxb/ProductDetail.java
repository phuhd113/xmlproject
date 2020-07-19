
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
 *         &lt;element name="Core" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Thread" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Frequency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Turbo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MemoryType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MemoryMax" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Socket" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Overclocking" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CoreBenchMark" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProductDetailID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "core",
    "thread",
    "frequency",
    "turbo",
    "memoryType",
    "memoryMax",
    "socket",
    "overclocking",
    "coreBenchMark"
})
@XmlRootElement(name = "ProductDetail")
public class ProductDetail {

    @XmlElement(name = "Core", required = true)
    protected String core;
    @XmlElement(name = "Thread", required = true)
    protected String thread;
    @XmlElement(name = "Frequency", required = true)
    protected String frequency;
    @XmlElement(name = "Turbo", required = true)
    protected String turbo;
    @XmlElement(name = "MemoryType", required = true)
    protected String memoryType;
    @XmlElement(name = "MemoryMax", required = true)
    protected String memoryMax;
    @XmlElement(name = "Socket", required = true)
    protected String socket;
    @XmlElement(name = "Overclocking")
    protected boolean overclocking;
    @XmlElement(name = "CoreBenchMark")
    protected long coreBenchMark;
    @XmlAttribute(name = "ProductDetailID", required = true)
    protected int productDetailID;

    /**
     * Gets the value of the core property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCore() {
        return core;
    }

    /**
     * Sets the value of the core property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCore(String value) {
        this.core = value;
    }

    /**
     * Gets the value of the thread property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThread() {
        return thread;
    }

    /**
     * Sets the value of the thread property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThread(String value) {
        this.thread = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequency(String value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the turbo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTurbo() {
        return turbo;
    }

    /**
     * Sets the value of the turbo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTurbo(String value) {
        this.turbo = value;
    }

    /**
     * Gets the value of the memoryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemoryType() {
        return memoryType;
    }

    /**
     * Sets the value of the memoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemoryType(String value) {
        this.memoryType = value;
    }

    /**
     * Gets the value of the memoryMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemoryMax() {
        return memoryMax;
    }

    /**
     * Sets the value of the memoryMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemoryMax(String value) {
        this.memoryMax = value;
    }

    /**
     * Gets the value of the socket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocket() {
        return socket;
    }

    /**
     * Sets the value of the socket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocket(String value) {
        this.socket = value;
    }

    /**
     * Gets the value of the overclocking property.
     * 
     */
    public boolean isOverclocking() {
        return overclocking;
    }

    /**
     * Sets the value of the overclocking property.
     * 
     */
    public void setOverclocking(boolean value) {
        this.overclocking = value;
    }

    /**
     * Gets the value of the coreBenchMark property.
     * 
     */
    public long getCoreBenchMark() {
        return coreBenchMark;
    }

    /**
     * Sets the value of the coreBenchMark property.
     * 
     */
    public void setCoreBenchMark(long value) {
        this.coreBenchMark = value;
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

}
