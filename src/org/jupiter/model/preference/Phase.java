
package org.jupiter.model.preference;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}ColumnEntry" maxOccurs="16" minOccurs="16"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}name"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "columnEntry"
})
@XmlRootElement(name = "Phase")
public class Phase {

    @XmlElement(name = "ColumnEntry", required = true)
    protected List<ColumnEntry> columnEntry;
    @XmlAttribute
    protected String name;

    /**
     * Gets the value of the columnEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnEntry }
     * 
     * 
     */
    public List<ColumnEntry> getColumnEntry() {
        if (columnEntry == null) {
            columnEntry = new ArrayList<ColumnEntry>();
        }
        return this.columnEntry;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
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
    public void setName(String value) {
        this.name = value;
    }

}
