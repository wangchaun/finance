package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> DataInfo <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class DataInfo{
    @XmlElement(name = "PocketInfo")
    private PocketInfo pocketInfo; //null

    @XmlElement(name = "BussinessData")
    private BussinessData bussinessData; //null

 
    @XmlTransient
    public PocketInfo getPocketInfo() {
        return pocketInfo;
    }
    public void setPocketInfo(PocketInfo pocketInfo) {
        this.pocketInfo = pocketInfo;
    }
    @XmlTransient
    public BussinessData getBussinessData() {
        return bussinessData;
    }
    public void setBussinessData(BussinessData bussinessData) {
        this.bussinessData = bussinessData;
    }
}
