//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.02 at 11:50:02 AM BST 
//

package org.orcid.jaxb.model.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@Deprecated
@XmlRootElement(name = "external-id-source")
public class ExternalIdSource extends OrcidIdBase implements Serializable {

    private static final long serialVersionUID = 1L;

    public ExternalIdSource() {
        super();
    }

    public ExternalIdSource(String path) {
        super(path);
    }

    public ExternalIdSource(OrcidIdBase other) {
        super(other);
    }

}
