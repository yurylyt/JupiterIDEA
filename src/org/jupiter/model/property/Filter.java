
package org.jupiter.model.property;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute ref="{}name"/>
 *       &lt;attribute ref="{}value"/>
 *       &lt;attribute ref="{}enabled"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Filter")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Filter {

    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String name;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String value;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected Boolean enabled;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

}
