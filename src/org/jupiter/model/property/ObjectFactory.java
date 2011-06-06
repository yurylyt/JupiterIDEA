
package org.jupiter.model.property;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jupiter.model.property package. 
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

    private final static QName _Description_QNAME = new QName("", "Description");
    private final static QName _Author_QNAME = new QName("", "Author");
    private final static QName _Directory_QNAME = new QName("", "Directory");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jupiter.model.property
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FieldItem }
     * 
     */
    public FieldItem createFieldItem() {
        return new FieldItem();
    }

    /**
     * Create an instance of {@link CreationDate }
     * 
     */
    public CreationDate createCreationDate() {
        return new CreationDate();
    }

    /**
     * Create an instance of {@link Phase }
     * 
     */
    public Phase createPhase() {
        return new Phase();
    }

    /**
     * Create an instance of {@link Filters }
     * 
     */
    public Filters createFilters() {
        return new Filters();
    }

    /**
     * Create an instance of {@link Reviewers }
     * 
     */
    public Reviewers createReviewers() {
        return new Reviewers();
    }

    /**
     * Create an instance of {@link Files }
     * 
     */
    public Files createFiles() {
        return new Files();
    }

    /**
     * Create an instance of {@link Files.Entry }
     * 
     */
    public Files.Entry createFilesEntry() {
        return new Files.Entry();
    }

    /**
     * Create an instance of {@link Review }
     * 
     */
    public Review createReview() {
        return new Review();
    }

    /**
     * Create an instance of {@link FieldItem.Entry }
     * 
     */
    public FieldItem.Entry createFieldItemEntry() {
        return new FieldItem.Entry();
    }

    /**
     * Create an instance of {@link Filter }
     * 
     */
    public Filter createFilter() {
        return new Filter();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link Reviewers.Entry }
     * 
     */
    public Reviewers.Entry createReviewersEntry() {
        return new Reviewers.Entry();
    }

    /**
     * Create an instance of {@link FieldItems }
     * 
     */
    public FieldItems createFieldItems() {
        return new FieldItems();
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
    @XmlElementDecl(namespace = "", name = "Author")
    public JAXBElement<String> createAuthor(String value) {
        return new JAXBElement<String>(_Author_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Directory")
    public JAXBElement<String> createDirectory(String value) {
        return new JAXBElement<String>(_Directory_QNAME, String.class, null, value);
    }

}
