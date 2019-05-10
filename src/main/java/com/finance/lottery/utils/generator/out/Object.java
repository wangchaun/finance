package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> Object <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class Object{
    @XmlElement(name = "Package")
    private Package apackage; //null

 
    @XmlTransient
    public Package getApackage() {
        return apackage;
    }
    public void setApackage(Package apackage) {
        this.apackage = apackage;
    }
}
