
package org.jupiter.model.review;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}CreationDate"/>
 *         &lt;element ref="{}LastModificationDate"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "creationDate",
    "lastModificationDate"
})
@XmlRootElement(name = "ReviewIssueMeta")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class ReviewIssueMeta {

    @XmlElement(name = "CreationDate", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected CreationDate creationDate;
    @XmlElement(name = "LastModificationDate", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected LastModificationDate lastModificationDate;

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link CreationDate }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public CreationDate getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationDate }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setCreationDate(CreationDate value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the lastModificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link LastModificationDate }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public LastModificationDate getLastModificationDate() {
        return lastModificationDate;
    }

    /**
     * Sets the value of the lastModificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LastModificationDate }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setLastModificationDate(LastModificationDate value) {
        this.lastModificationDate = value;
    }

}
