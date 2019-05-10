package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> SignedInfo <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class SignedInfo{
    @XmlElement(name = "Reference")
    private Reference reference; //null

    @XmlElement(name = "CanonicalizationMethod")
    private String canonicalizationMethod; //null

    @XmlElement(name = "SignatureMethod")
    private String signatureMethod; //null

 
    @XmlTransient
    public Reference getReference() {
        return reference;
    }
    public void setReference(Reference reference) {
        this.reference = reference;
    }
    @XmlTransient
    public String getCanonicalizationMethod() {
        return canonicalizationMethod;
    }
    public void setCanonicalizationMethod(String canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }
    @XmlTransient
    public String getSignatureMethod() {
        return signatureMethod;
    }
    public void setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }
}
