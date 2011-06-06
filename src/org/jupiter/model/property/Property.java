
package org.jupiter.model.property;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}Review" maxOccurs="unbounded"/>
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
    "review"
})
@XmlRootElement(name = "Property")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Property {

    @XmlElement(name = "Review", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<Review> review;

    /**
     * Gets the value of the review property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the review property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReview().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Review }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<Review> getReview() {
        if (review == null) {
            review = new ArrayList<Review>();
        }
        return this.review;
    }

}
