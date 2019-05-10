package com.finance.lottery.utils.generator.GenModel;

import java.util.List;

/**
 * @program: zeus-parent
 * @description:
 * @author: siming.wang
 * @create: 2019-05-10 11:58
 **/

public class JsonSingleModelVO {

    private String className;

    private String authorInfo;

    private boolean isUsedLambda = false;

    private List<Attribute> attributes;


    public class Attribute{

        private String attributeName;

        private String attributeType;  //json 原类型

        private String attributeJavaType; //java类型

        private String attributeComments;

        private JsonSingleModelVO jsonSingleModelVO;

        private String attributeAnontation;


        public JsonSingleModelVO getJsonSingleModelVO() {
            return jsonSingleModelVO;
        }

        public void setJsonSingleModelVO(JsonSingleModelVO jsonSingleModelVO) {
            this.jsonSingleModelVO = jsonSingleModelVO;
        }

        public String getAttributeJavaType() {
            return attributeJavaType;
        }

        public void setAttributeJavaType(String attributeJavaType) {
            this.attributeJavaType = attributeJavaType;
        }

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public String getAttributeType() {
            return attributeType;
        }

        public void setAttributeType(String attributeType) {
            this.attributeType = attributeType;
        }

        public String getAttributeComments() {
            return attributeComments;
        }

        public void setAttributeComments(String attributeComments) {
            this.attributeComments = attributeComments;
        }

        public String getAttributeAnontation() {
            return attributeAnontation;
        }

        public void setAttributeAnontation(String attributeAnontation) {
            this.attributeAnontation = attributeAnontation;
        }
    }



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    public boolean isUsedLambda() {
        return isUsedLambda;
    }

    public void setUsedLambda(boolean usedLambda) {
        isUsedLambda = usedLambda;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
