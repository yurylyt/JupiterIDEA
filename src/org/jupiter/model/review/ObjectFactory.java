
package org.jupiter.model.review;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jupiter.model.review package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Status_QNAME = new QName("", "Status");
    private final static QName _Description_QNAME = new QName("", "Description");
    private final static QName _Severity_QNAME = new QName("", "Severity");
    private final static QName _Resolution_QNAME = new QName("", "Resolution");
    private final static QName _Type_QNAME = new QName("", "Type");
    private final static QName _Annotation_QNAME = new QName("", "Annotation");
    private final static QName _ReviewerId_QNAME = new QName("", "ReviewerId");
    private final static QName _Revision_QNAME = new QName("", "Revision");
    private final static QName _AssignedTo_QNAME = new QName("", "AssignedTo");
    private final static QName _Summary_QNAME = new QName("", "Summary");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jupiter.model.review
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReviewIssue }
     * 
     */
    public ReviewIssue createReviewIssue() {
        return new ReviewIssue();
    }

    /**
     * Create an instance of {@link Review }
     * 
     */
    public Review createReview() {
        return new Review();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link CreationDate }
     * 
     */
    public CreationDate createCreationDate() {
        return new CreationDate();
    }

    /**
     * Create an instance of {@link ReviewIssueMeta }
     * 
     */
    public ReviewIssueMeta createReviewIssueMeta() {
        return new ReviewIssueMeta();
    }

    /**
     * Create an instance of {@link LastModificationDate }
     * 
     */
    public LastModificationDate createLastModificationDate() {
        return new LastModificationDate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Severity")
    public JAXBElement<String> createSeverity(String value) {
        return new JAXBElement<String>(_Severity_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Resolution")
    public JAXBElement<String> createResolution(String value) {
        return new JAXBElement<String>(_Resolution_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Annotation")
    public JAXBElement<String> createAnnotation(String value) {
        return new JAXBElement<String>(_Annotation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ReviewerId")
    public JAXBElement<String> createReviewerId(String value) {
        return new JAXBElement<String>(_ReviewerId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Revision")
    public JAXBElement<String> createRevision(String value) {
        return new JAXBElement<String>(_Revision_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AssignedTo")
    public JAXBElement<String> createAssignedTo(String value) {
        return new JAXBElement<String>(_AssignedTo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Summary")
    public JAXBElement<String> createSummary(String value) {
        return new JAXBElement<String>(_Summary_QNAME, String.class, null, value);
    }

}
