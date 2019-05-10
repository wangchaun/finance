package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> BussinessData <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class BussinessData{
    @XmlElement(name = "InvtMessage")
    private InvtMessage invtMessage; //null

    @XmlElement(name = "DelcareFlag")
    private String delcareFlag; //1

 
    @XmlTransient
    public InvtMessage getInvtMessage() {
        return invtMessage;
    }
    public void setInvtMessage(InvtMessage invtMessage) {
        this.invtMessage = invtMessage;
    }
    @XmlTransient
    public String getDelcareFlag() {
        return delcareFlag;
    }
    public void setDelcareFlag(String delcareFlag) {
        this.delcareFlag = delcareFlag;
    }
}
