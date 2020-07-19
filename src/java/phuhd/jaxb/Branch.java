
package phuhd.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Branch.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Branch">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Intel"/>
 *     &lt;enumeration value="AMD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Branch", namespace = "www.PhuHDShop.Product.com")
@XmlEnum
public enum Branch {

    @XmlEnumValue("Intel")
    INTEL("Intel"),
    AMD("AMD");
    private final String value;

    Branch(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Branch fromValue(String v) {
        for (Branch c: Branch.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
