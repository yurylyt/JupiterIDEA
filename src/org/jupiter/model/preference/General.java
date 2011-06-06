
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
 *         &lt;element ref="{}UpdateUrl"/>
 *         &lt;element ref="{}EnableUpdate"/>
 *         &lt;element ref="{}EnableFilter"/>
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
    "updateUrl",
    "enableUpdate",
    "enableFilter"
})
@XmlRootElement(name = "General")
public class General {

    @XmlElement(name = "UpdateUrl", required = true)
    protected String updateUrl;
    @XmlElement(name = "EnableUpdate")
    protected boolean enableUpdate;
    @XmlElement(name = "EnableFilter")
    protected boolean enableFilter;

    /**
     * Gets the value of the updateUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateUrl() {
        return updateUrl;
    }

    /**
     * Sets the value of the updateUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateUrl(String value) {
        this.updateUrl = value;
    }

    /**
     * Gets the value of the enableUpdate property.
     * 
     */
    public boolean isEnableUpdate() {
        return enableUpdate;
    }

    /**
     * Sets the value of the enableUpdate property.
     * 
     */
    public void setEnableUpdate(boolean value) {
        this.enableUpdate = value;
    }

    /**
     * Gets the value of the enableFilter property.
     * 
     */
    public boolean isEnableFilter() {
        return enableFilter;
    }

    /**
     * Sets the value of the enableFilter property.
     * 
     */
    public void setEnableFilter(boolean value) {
        this.enableFilter = value;
    }

}
