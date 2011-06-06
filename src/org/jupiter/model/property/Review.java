
package org.jupiter.model.property;

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
 *         &lt;element ref="{}Description"/>
 *         &lt;element ref="{}Author"/>
 *         &lt;element ref="{}CreationDate"/>
 *         &lt;element ref="{}Directory"/>
 *         &lt;element ref="{}Reviewers"/>
 *         &lt;element ref="{}Files"/>
 *         &lt;element ref="{}FieldItems"/>
 *         &lt;element ref="{}Filters"/>
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
    "description",
    "author",
    "creationDate",
    "directory",
    "reviewers",
    "files",
    "fieldItems",
    "filters"
})
@XmlRootElement(name = "Review")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Review {

    @XmlElement(name = "Description", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String description;
    @XmlElement(name = "Author", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String author;
    @XmlElement(name = "CreationDate", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected CreationDate creationDate;
    @XmlElement(name = "Directory", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String directory;
    @XmlElement(name = "Reviewers", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected Reviewers reviewers;
    @XmlElement(name = "Files", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected Files files;
    @XmlElement(name = "FieldItems", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected FieldItems fieldItems;
    @XmlElement(name = "Filters", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected Filters filters;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String id;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link CreationDate }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setCreationDate(CreationDate value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the directory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getDirectory() {
        return directory;
    }

    /**
     * Sets the value of the directory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setDirectory(String value) {
        this.directory = value;
    }

    /**
     * Gets the value of the reviewers property.
     * 
     * @return
     *     possible object is
     *     {@link Reviewers }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public Reviewers getReviewers() {
        return reviewers;
    }

    /**
     * Sets the value of the reviewers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reviewers }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setReviewers(Reviewers value) {
        this.reviewers = value;
    }

    /**
     * Gets the value of the files property.
     * 
     * @return
     *     possible object is
     *     {@link Files }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public Files getFiles() {
        return files;
    }

    /**
     * Sets the value of the files property.
     * 
     * @param value
     *     allowed object is
     *     {@link Files }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setFiles(Files value) {
        this.files = value;
    }

    /**
     * Gets the value of the fieldItems property.
     * 
     * @return
     *     possible object is
     *     {@link FieldItems }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public FieldItems getFieldItems() {
        return fieldItems;
    }

    /**
     * Sets the value of the fieldItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldItems }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setFieldItems(FieldItems value) {
        this.fieldItems = value;
    }

    /**
     * Gets the value of the filters property.
     * 
     * @return
     *     possible object is
     *     {@link Filters }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public Filters getFilters() {
        return filters;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Filters }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setFilters(Filters value) {
        this.filters = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:29:58+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setId(String value) {
        this.id = value;
    }

}
