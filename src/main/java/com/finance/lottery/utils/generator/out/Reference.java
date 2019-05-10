package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> Reference <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class Reference{
    @XmlElement(name = "DigestMethod")
    private String digestMethod; //null

    @XmlElement(name = "DigestValue")
    private String digestValue; //string

 
    @XmlTransient
    public String getDigestMethod() {
        return digestMethod;
    }
    public void setDigestMethod(String digestMethod) {
        this.digestMethod = digestMethod;
    }
    @XmlTransient
    public String getDigestValue() {
        return digestValue;
    }
    public void setDigestValue(String digestValue) {
        this.digestValue = digestValue;
    }
}
