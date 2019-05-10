package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> KeyInfo <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class KeyInfo{
    @XmlElement(name = "KeyName")
    private String keyName; //aa

 
    @XmlTransient
    public String getKeyName() {
        return keyName;
    }
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
