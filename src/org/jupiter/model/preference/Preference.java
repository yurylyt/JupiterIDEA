
package org.jupiter.model.preference;

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
 *         &lt;element ref="{}General"/>
 *         &lt;element ref="{}View"/>
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
    "general",
    "view"
})
@XmlRootElement(name = "Preference")
public class Preference {

    @XmlElement(name = "General", required = true)
    protected General general;
    @XmlElement(name = "View", required = true)
    protected View view;

    /**
     * Gets the value of the general property.
     * 
     * @return
     *     possible object is
     *     {@link General }
     *     
     */
    public General getGeneral() {
        return general;
    }

    /**
     * Sets the value of the general property.
     * 
     * @param value
     *     allowed object is
     *     {@link General }
     *     
     */
    public void setGeneral(General value) {
        this.general = value;
    }

    /**
     * Gets the value of the view property.
     * 
     * @return
     *     possible object is
     *     {@link View }
     *     
     */
    public View getView() {
        return view;
    }

    /**
     * Sets the value of the view property.
     * 
     * @param value
     *     allowed object is
     *     {@link View }
     *     
     */
    public void setView(View value) {
        this.view = value;
    }

}
