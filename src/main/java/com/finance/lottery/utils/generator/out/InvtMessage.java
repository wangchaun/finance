package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> InvtMessage <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class InvtMessage{
    @XmlElement(name = "InvtCbecBill")
    private InvtCbecBill invtCbecBill; //null

    @XmlElement(name = "InvtListType")
    private InvtListType invtListType; //null

    @XmlElement(name = "SysId")
    private String sysId; //Z8

    @XmlElement(name = "OperCusRegCode")
    private String operCusRegCode; //6620180410

    @XmlElement(name = "InvtHeadType")
    private InvtHeadType invtHeadType; //null

 
    @XmlTransient
    public InvtCbecBill getInvtCbecBill() {
        return invtCbecBill;
    }
    public void setInvtCbecBill(InvtCbecBill invtCbecBill) {
        this.invtCbecBill = invtCbecBill;
    }
    @XmlTransient
    public InvtListType getInvtListType() {
        return invtListType;
    }
    public void setInvtListType(InvtListType invtListType) {
        this.invtListType = invtListType;
    }
    @XmlTransient
    public String getSysId() {
        return sysId;
    }
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }
    @XmlTransient
    public String getOperCusRegCode() {
        return operCusRegCode;
    }
    public void setOperCusRegCode(String operCusRegCode) {
        this.operCusRegCode = operCusRegCode;
    }
    @XmlTransient
    public InvtHeadType getInvtHeadType() {
        return invtHeadType;
    }
    public void setInvtHeadType(InvtHeadType invtHeadType) {
        this.invtHeadType = invtHeadType;
    }
}
