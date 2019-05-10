package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> InvtCbecBill <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class InvtCbecBill{
    @XmlElement(name = "CbecBillNo")
    private String cbecBillNo; //1040551272S10

    @XmlElement(name = "BondInvtNo")
    private String bondInvtNo; //0100H19050000002

 
    @XmlTransient
    public String getCbecBillNo() {
        return cbecBillNo;
    }
    public void setCbecBillNo(String cbecBillNo) {
        this.cbecBillNo = cbecBillNo;
    }
    @XmlTransient
    public String getBondInvtNo() {
        return bondInvtNo;
    }
    public void setBondInvtNo(String bondInvtNo) {
        this.bondInvtNo = bondInvtNo;
    }
}
