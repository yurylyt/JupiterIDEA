
package org.jupiter.model.review;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute ref="{}line"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "File")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class File {

    @XmlValue
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String value;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected Integer line;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public Integer getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setLine(Integer value) {
        this.line = value;
    }

}
