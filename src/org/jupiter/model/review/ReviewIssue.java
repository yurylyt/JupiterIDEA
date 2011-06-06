
package org.jupiter.model.review;

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
 *         &lt;element ref="{}ReviewIssueMeta"/>
 *         &lt;element ref="{}ReviewerId"/>
 *         &lt;element ref="{}AssignedTo"/>
 *         &lt;element ref="{}File"/>
 *         &lt;element ref="{}Type"/>
 *         &lt;element ref="{}Severity"/>
 *         &lt;element ref="{}Summary"/>
 *         &lt;element ref="{}Description"/>
 *         &lt;element ref="{}Annotation"/>
 *         &lt;element ref="{}Revision"/>
 *         &lt;element ref="{}Resolution"/>
 *         &lt;element ref="{}Status"/>
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
    "reviewIssueMeta",
    "reviewerId",
    "assignedTo",
    "file",
    "type",
    "severity",
    "summary",
    "description",
    "annotation",
    "revision",
    "resolution",
    "status"
})
@XmlRootElement(name = "ReviewIssue")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class ReviewIssue {

    @XmlElement(name = "ReviewIssueMeta", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected ReviewIssueMeta reviewIssueMeta;
    @XmlElement(name = "ReviewerId", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String reviewerId;
    @XmlElement(name = "AssignedTo", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String assignedTo;
    @XmlElement(name = "File", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected File file;
    @XmlElement(name = "Type", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String type;
    @XmlElement(name = "Severity", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String severity;
    @XmlElement(name = "Summary", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String summary;
    @XmlElement(name = "Description", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String description;
    @XmlElement(name = "Annotation", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String annotation;
    @XmlElement(name = "Revision", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String revision;
    @XmlElement(name = "Resolution", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String resolution;
    @XmlElement(name = "Status", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String status;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String id;

    /**
     * Gets the value of the reviewIssueMeta property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewIssueMeta }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public ReviewIssueMeta getReviewIssueMeta() {
        return reviewIssueMeta;
    }

    /**
     * Sets the value of the reviewIssueMeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewIssueMeta }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setReviewIssueMeta(ReviewIssueMeta value) {
        this.reviewIssueMeta = value;
    }

    /**
     * Gets the value of the reviewerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getReviewerId() {
        return reviewerId;
    }

    /**
     * Sets the value of the reviewerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setReviewerId(String value) {
        this.reviewerId = value;
    }

    /**
     * Gets the value of the assignedTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets the value of the assignedTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setAssignedTo(String value) {
        this.assignedTo = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link File }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public File getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link File }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setFile(File value) {
        this.file = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setAnnotation(String value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setRevision(String value) {
        this.revision = value;
    }

    /**
     * Gets the value of the resolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setResolution(String value) {
        this.resolution = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2011-05-28T05:32:37+03:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setStatus(String value) {
        this.status = value;
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
