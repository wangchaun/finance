package com.finance.lottery.utils.generator.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finance.lottery.utils.generator.GenModel.JsonSingleModelVO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <B>Description:</B> 读取表信息 <br>
 * <B>Create on:</B> 2018/5/5 下午2:11 <br>
 *
 * @author xiangyu.ye
 * @version 1.0
 */
public class ReadJsonUtil {

    public static void main(String[] args) {
        JsonSingleModelVO jsonSingleModelVO = getJsonInfo();
        System.out.println(JSON.toJSONString(jsonSingleModelVO));
    }



    /**
     * <B>Description:</B> 获取 db字段信息list <br>
     * <B>Create on:</B> 2018/5/5 下午1:29 <br>
     *
     * @author xiangyu.ye
     */
    public static JsonSingleModelVO getJsonInfo() {

        JsonSingleModelVO result = null;
        try {
            result = new JsonSingleModelVO();

            String jsonStr;

            jsonStr = FileUtils.readFileToString(new File(
                        PathUtil.getProjectPath() + "/src/main/java/com/finance/lottery/utils/generator/util/json.txt"));

            JSONObject jsonObject = JSON.parseObject(jsonStr);

            result = getSingleModelFromJson(jsonObject, "Root");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }



    private static JsonSingleModelVO getSingleModelFromJson(JSONObject jsonObject, String rootClassName){

        JsonSingleModelVO jsonSingleModelVO = new JsonSingleModelVO();
        jsonSingleModelVO.setClassName(rootClassName);
        jsonSingleModelVO.setAuthorInfo("");

        List<JsonSingleModelVO.Attribute> attributes = new ArrayList<>();

        //1、先解析第一层的hash map
        for (Map.Entry<String, Object> et : jsonObject.entrySet()){

            JsonSingleModelVO.Attribute attribute = jsonSingleModelVO.new Attribute();


            String classKeyName = et.getKey();
            if(classKeyName.contains("-")){
                continue;
            }
            Object attributeObject = et.getValue();

            //2、遍历hash map的key和对应的value
            //如果是json object类型
            attribute.setAttributeName(CamelUnderUtil.camelHump(classKeyName));
            attribute.setAttributeAnontation("@XmlElement(name = \""+classKeyName+"\")");

            if(attributeObject instanceof JSONObject){
                attribute.setJsonSingleModelVO(getSingleModelFromJson((JSONObject)attributeObject, classKeyName));
            }else {
                attribute.setAttributeJavaType("String");
                attribute.setAttributeComments(attributeObject.toString());
            }

            attributes.add(attribute);
        }

        jsonSingleModelVO.setAttributes(attributes);
        return jsonSingleModelVO;
    }


    /**
     * <B>Description:</B> 去除不需要字符 <br>
     * <B>Create on:</B> 2019-03-24 20:28 <br>
     *
     * @author xiangyu.ye
     */
    private static String removeUnnecessaryCharacters(String ddlStr) {
        ddlStr = StringUtils.remove(ddlStr, "`");
        ddlStr = StringUtils.remove(ddlStr, "USING BTREE");

        String[] split = StringUtils.split(ddlStr, "\n");
        StringBuilder ddlStrNew = new StringBuilder();
        for (String str : split) {
            str = StringUtils.trim(str);
            //主键删除逗号
            if(StringUtils.startsWith(str.toUpperCase(),"PRIMARY")){
                str = StringUtils.remove(str, ",");
            }
            //索引删除
            if(!StringUtils.startsWith(str.toUpperCase(),"KEY")){
                ddlStrNew.append(str);
                ddlStrNew.append("\n");
            }
        }
        return ddlStrNew.toString();
    }


    /**
     * <B>Description:</B> 设置java类型 <br>
     * <B>Create on:</B> 2017/4/11 10:30 <br>
     *
     * @author xiangyu.ye
     */
//    private static void setFieldJavaType(List<Columnt> columntList) {
//
//        if (CollectionUtils.isEmpty(columntList)) {
//            return;
//        }
//
//        for (Columnt columnt : columntList) {
//            String fieldType = columnt.getFieldDbType();
//
//            fieldType = fieldType.toLowerCase();
//
//            if (fieldType.contains("char")) {
//                fieldType = "java.lang.String";
//            } else if (fieldType.equals("tinyint")) {
//                fieldType = "java.lang.Integer";
//            } else if (fieldType.equals("smallint")) {
//                fieldType = "java.lang.Integer";
//            } else if (fieldType.equals("int")) {
//                fieldType = "java.lang.Integer";
//            } else if (fieldType.equals("bigint")) {
//                fieldType = "java.lang.Long";
//            } else if (fieldType.contains("float")) {
//                fieldType = "java.lang.Float";
//            } else if (fieldType.contains("double")) {
//                fieldType = "java.lang.Double";
//            } else if (fieldType.contains("number")) {
//                if ("mysql".equals("mysql")) {
//                    fieldType = "java.math.BigDecimal";//针对feiniu,mysql用     Add by xiangyu.ye 2016/5/30 11:19
//                }
//                /*if (StringUtils.isNotBlank(scale) && Integer.parseInt(scale) > 0) {
//                    fieldType = "java.math.BigDecimal";
//                } else if (StringUtils.isNotBlank(precision) && Integer.parseInt(precision) > 10) {
//                    fieldType = "java.lang.Long";
//                } else {
//                    fieldType = "java.lang.Integer";
//                }*/
//            } else if (fieldType.contains("decimal")) {
//                fieldType = "BigDecimal";
//            } else if (fieldType.contains("date")) {
//                fieldType = "java.util.Date";
//                columnt.setClassType(Columnt.ClassTypeEnum.DATE_TIME);
//            } else if (fieldType.contains("time")) {
//                fieldType = "java.util.Date";
//                columnt.setClassType(Columnt.ClassTypeEnum.DATE_TIME);
//            } else if (fieldType.contains("blob")) {
//                fieldType = "byte[]";
//            } else if (fieldType.contains("clob")) {
//                fieldType = "java.sql.Clob";
//            } else if (fieldType.contains("numeric")) {
//                fieldType = "BigDecimal";
//            } else {
//                fieldType = "java.lang.ObjectBean";
//            }
//
//            columnt.setFieldJavaType(fieldType);
//        }
//    }
}
