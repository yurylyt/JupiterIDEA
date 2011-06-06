
package org.jupiter.model.preference;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jupiter.model.preference package. 
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

    private final static QName _EnableFilter_QNAME = new QName("", "EnableFilter");
    private final static QName _UpdateUrl_QNAME = new QName("", "UpdateUrl");
    private final static QName _EnableUpdate_QNAME = new QName("", "EnableUpdate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jupiter.model.preference
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ColumnEntry }
     * 
     */
    public ColumnEntry createColumnEntry() {
        return new ColumnEntry();
    }

    /**
     * Create an instance of {@link Phase }
     * 
     */
    public Phase createPhase() {
        return new Phase();
    }

    /**
     * Create an instance of {@link View }
     * 
     */
    public View createView() {
        return new View();
    }

    /**
     * Create an instance of {@link Preference }
     * 
     */
    public Preference createPreference() {
        return new Preference();
    }

    /**
     * Create an instance of {@link General }
     * 
     */
    public General createGeneral() {
        return new General();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EnableFilter")
    public JAXBElement<Boolean> createEnableFilter(Boolean value) {
        return new JAXBElement<Boolean>(_EnableFilter_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UpdateUrl")
    public JAXBElement<String> createUpdateUrl(String value) {
        return new JAXBElement<String>(_UpdateUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EnableUpdate")
    public JAXBElement<Boolean> createEnableUpdate(Boolean value) {
        return new JAXBElement<Boolean>(_EnableUpdate_QNAME, Boolean.class, null, value);
    }

}
