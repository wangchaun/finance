package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.lang.Object;


/**
* <B>Description:</B> Signature <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class Signature{
    @XmlElement(name = "SignatureValue")
    private String signatureValue; //string

    @XmlElement(name = "KeyInfo")
    private KeyInfo keyInfo; //null

    @XmlElement(name = "Object")
    private Object object; //null

    @XmlElement(name = "SignedInfo")
    private SignedInfo signedInfo; //null


    @XmlTransient
    public String getSignatureValue() {
        return signatureValue;
    }
    public void setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
    }
    @XmlTransient
    public KeyInfo getKeyInfo() {
        return keyInfo;
    }
    public void setKeyInfo(KeyInfo keyInfo) {
        this.keyInfo = keyInfo;
    }
    @XmlTransient
    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
    @XmlTransient
    public SignedInfo getSignedInfo() {
        return signedInfo;
    }
    public void setSignedInfo(SignedInfo signedInfo) {
        this.signedInfo = signedInfo;
    }
}
