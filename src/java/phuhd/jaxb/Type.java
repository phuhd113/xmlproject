
package phuhd.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Celeron"/>
 *     &lt;enumeration value="Pentium"/>
 *     &lt;enumeration value="Core i3"/>
 *     &lt;enumeration value="Core i5"/>
 *     &lt;enumeration value="Core i7"/>
 *     &lt;enumeration value="Core i9"/>
 *     &lt;enumeration value="Xeon"/>
 *     &lt;enumeration value="Athlon"/>
 *     &lt;enumeration value="Ryzen 3"/>
 *     &lt;enumeration value="Ryzen 5"/>
 *     &lt;enumeration value="Ryzen 7"/>
 *     &lt;enumeration value="Ryzen 9"/>
 *     &lt;enumeration value="Ryzen Threadripper"/>
 *     &lt;enumeration value="EPYC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Type", namespace = "www.PhuHDShop.Product.com")
@XmlEnum
public enum Type {

    @XmlEnumValue("Celeron")
    CELERON("Celeron"),
    @XmlEnumValue("Pentium")
    PENTIUM("Pentium"),
    @XmlEnumValue("Core i3")
    CORE_I_3("Core i3"),
    @XmlEnumValue("Core i5")
    CORE_I_5("Core i5"),
    @XmlEnumValue("Core i7")
    CORE_I_7("Core i7"),
    @XmlEnumValue("Core i9")
    CORE_I_9("Core i9"),
    @XmlEnumValue("Xeon")
    XEON("Xeon"),
    @XmlEnumValue("Athlon")
    ATHLON("Athlon"),
    @XmlEnumValue("Ryzen 3")
    RYZEN_3("Ryzen 3"),
    @XmlEnumValue("Ryzen 5")
    RYZEN_5("Ryzen 5"),
    @XmlEnumValue("Ryzen 7")
    RYZEN_7("Ryzen 7"),
    @XmlEnumValue("Ryzen 9")
    RYZEN_9("Ryzen 9"),
    @XmlEnumValue("Ryzen Threadripper")
    RYZEN_THREADRIPPER("Ryzen Threadripper"),
    EPYC("EPYC");
    private final String value;

    Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Type fromValue(String v) {
        for (Type c: Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
