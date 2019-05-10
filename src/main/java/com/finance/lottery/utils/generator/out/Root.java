package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> Root <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class Root{
    @XmlElement(name = "Signature")
    private Signature signature; //null

 
    @XmlTransient
    public Signature getSignature() {
        return signature;
    }
    public void setSignature(Signature signature) {
        this.signature = signature;
    }
}
