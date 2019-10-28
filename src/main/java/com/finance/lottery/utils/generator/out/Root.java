package com.zeus.enuclearRelease.generator.out;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


/**
* <B>Description:</B> Root <br>
* <B>Create on:</B> 123 <br>
*
* @author kyubi.wang
* @version 1.0
*/

public class Root{
    @XmlElement(name = "creator")
    private String creator; //吴倩

    @XmlElement(name = "purchase_score")
    private String purchaseScore; //50.0

    @XmlElement(name = "provider")
    private String provider; //003001392

    @XmlElement(name = "sku_score_list")
    private String skuScoreList; //[{"skucode":"93232180","sku_weight":14450.4,"purchase_total":100,"arrive_total":0}]

    @XmlElement(name = "order_number")
    private String orderNumber; //P52008

    @XmlElement(name = "last_status")
    private String lastStatus; //8

    @XmlElement(name = "delivery_time")
    private String deliveryTime; //2017-11-28

    @XmlElement(name = "provider_name")
    private String providerName; //测试 FOB 全款

    @XmlElement(name = "date_key")
    private String dateKey; //2017-11-25

    @XmlElement(name = "purchase_form_weight")
    private String purchaseFormWeight; //14450.4

 
    @XmlTransient
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    @XmlTransient
    public String getPurchaseScore() {
        return purchaseScore;
    }
    public void setPurchaseScore(String purchaseScore) {
        this.purchaseScore = purchaseScore;
    }
    @XmlTransient
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    @XmlTransient
    public String getSkuScoreList() {
        return skuScoreList;
    }
    public void setSkuScoreList(String skuScoreList) {
        this.skuScoreList = skuScoreList;
    }
    @XmlTransient
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    @XmlTransient
    public String getLastStatus() {
        return lastStatus;
    }
    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }
    @XmlTransient
    public String getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    @XmlTransient
    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    @XmlTransient
    public String getDateKey() {
        return dateKey;
    }
    public void setDateKey(String dateKey) {
        this.dateKey = dateKey;
    }
    @XmlTransient
    public String getPurchaseFormWeight() {
        return purchaseFormWeight;
    }
    public void setPurchaseFormWeight(String purchaseFormWeight) {
        this.purchaseFormWeight = purchaseFormWeight;
    }
}
