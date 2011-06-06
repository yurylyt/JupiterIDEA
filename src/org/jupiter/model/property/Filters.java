
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
 *         &lt;element ref="{}Phase" maxOccurs="3" minOccurs="3"/>
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
    "phase"
})
@XmlRootElement(name = "Filters")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Filters {

    @XmlElement(name = "Phase", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<Phase> phase;

    /**
     * Gets the value of the phase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Phase }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<Phase> getPhase() {
        if (phase == null) {
            phase = new ArrayList<Phase>();
        }
        return this.phase;
    }

}
