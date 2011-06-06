
package org.jupiter.model.review;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
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
 *         &lt;element ref="{}ReviewIssue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}id"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reviewIssue"
})
@XmlRootElement(name = "Review")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Review {

    @XmlElement(name = "ReviewIssue")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<ReviewIssue> reviewIssue;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String id;

    /**
     * Gets the value of the reviewIssue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reviewIssue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReviewIssue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReviewIssue }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<ReviewIssue> getReviewIssue() {
        if (reviewIssue == null) {
            reviewIssue = new ArrayList<ReviewIssue>();
        }
        return this.reviewIssue;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setId(String value) {
        this.id = value;
    }

}
