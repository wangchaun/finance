package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> Package <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class Package{
    @XmlElement(name = "DataInfo")
    private DataInfo dataInfo; //null

    @XmlElement(name = "EnvelopInfo")
    private EnvelopInfo envelopInfo; //null

 
    @XmlTransient
    public DataInfo getDataInfo() {
        return dataInfo;
    }
    public void setDataInfo(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @XmlTransient
    public EnvelopInfo getEnvelopInfo() {
        return envelopInfo;
    }
    public void setEnvelopInfo(EnvelopInfo envelopInfo) {
        this.envelopInfo = envelopInfo;
    }
}
