package com.finance.lottery.utils.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> EnvelopInfo <br>
* <B>Create on:</B> 2019-05-10 15:51:56 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class EnvelopInfo{
    @XmlElement(name = "send_time")
    private String sendTime; //2019-05-06T09:36:35

    @XmlElement(name = "file_name")
    private String fileName; //BLS-INV-0100H19050000002-20190506093635918.xml

    @XmlElement(name = "receiver_id")
    private String receiverId; //1

    @XmlElement(name = "message_id")
    private String messageId; //BLS-INV-0100H19050000002-20190506093635918

    @XmlElement(name = "message_type")
    private String messageType; //INV101

    @XmlElement(name = "version")
    private String version; //1.0

    @XmlElement(name = "business_id")
    private String businessId; //0100H19050000002

    @XmlElement(name = "sender_id")
    private String senderId; //1

 
    @XmlTransient
    public String getSendTime() {
        return sendTime;
    }
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
    @XmlTransient
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @XmlTransient
    public String getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    @XmlTransient
    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    @XmlTransient
    public String getMessageType() {
        return messageType;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    @XmlTransient
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    @XmlTransient
    public String getBusinessId() {
        return businessId;
    }
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
    @XmlTransient
    public String getSenderId() {
        return senderId;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
}
