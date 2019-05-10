package com.finance.lottery.utils.generator;

import com.zeus.common.util.DateUtils;
import com.zeus.enuclearRelease.generator.GenModel.JsonSingleModelVO;
import com.zeus.enuclearRelease.generator.util.PathUtil;
import com.zeus.enuclearRelease.generator.util.ReadJsonUtil;
import com.zeus.enuclearRelease.generator.util.StringUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Date;

/**
 * @program: zeus-parent
 * @description:
 * @author: siming.wang
 * @create: 2019-05-09 13:41
 **/

public class JavaBeanGeneratorFromJson {

    public static void main(String[] args) throws Exception{

        JsonSingleModelVO jsonSingleModelVO = ReadJsonUtil.getJsonInfo();

        generaModelByModel(jsonSingleModelVO);

    }


    private static void generaModelByModel(JsonSingleModelVO jsonSingleModelVO) throws Exception{

        String nowDateTime  =  DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String file = PathUtil.getProjectPath()+"/src/main/java/com/zeus/enuclearRelease/generator/out/"+ jsonSingleModelVO.getClassName() +".java";

        String beanPropertyList = "" ;
        String getsetList = "" ;
        for(JsonSingleModelVO.Attribute attribute : jsonSingleModelVO.getAttributes()){
            if(attribute.getAttributeJavaType() != null){
                beanPropertyList = beanPropertyList +
                        "    "+attribute.getAttributeAnontation()+"\n"+
                        "    private "+ StringUtil.UpperFirst(attribute.getAttributeJavaType())+" "+StringUtil.LowerFirst(attribute.getAttributeName())+"; //"+attribute.getAttributeComments()+"\n"+"\n"
                ;
            }else if(attribute.getJsonSingleModelVO() != null){
                beanPropertyList = beanPropertyList +
                        "    "+attribute.getAttributeAnontation()+"\n"+
                        "    private "+attribute.getAttributeName()+" "+StringUtil.LowerFirst(attribute.getAttributeName())+"; //"+attribute.getAttributeComments()+"\n"+"\n"
                ;
                generaModelByModel(attribute.getJsonSingleModelVO());
            }

            getsetList = getsetList + generaGetMethod(attribute) + generaSetMethod(attribute);
        }

        String content =
                "package com.zeus.enuclearRelease.generator.out;\n"+
                "import javax.xml.bind.annotation.XmlElement;\n" +
                        "import javax.xml.bind.annotation.XmlTransient;\n" +
                        "\n" +
                        "\n" +
                        "/**\n" +
                        "* <B>Description:</B> "+jsonSingleModelVO.getClassName()+" <br>\n" +
                        "* <B>Create on:</B> "+nowDateTime+" <br>\n" +
                        "*\n" +
                        "* @author kyubi.wang\n" +
                        "* @version 1.0\n" +
                        "*/\n" +
                        "\n" +
                        "public class "+jsonSingleModelVO.getClassName()+"{\n" +
                        beanPropertyList+
                        " \n" +
                        getsetList +
                        "}\n"
                ;

        System.out.println(content);
        FileUtils.writeStringToFile(new File(file),content,false);

    }


    private static String generaGetMethod(JsonSingleModelVO.Attribute attribute){

        String getStr = "";

        if(attribute.getAttributeJavaType() != null){
            getStr ="    @XmlTransient\n"+
                    "    public "+StringUtil.UpperFirst(attribute.getAttributeJavaType())+" get"+StringUtil.UpperFirst(attribute.getAttributeName())+"() {\n" +
                    "        return "+StringUtil.LowerFirst(attribute.getAttributeName())+";\n" +
                    "    }\n";

        }else if(attribute.getJsonSingleModelVO() != null){
            getStr ="    @XmlTransient\n"+
                    "    public "+attribute.getAttributeName()+" get"+attribute.getAttributeName()+"() {\n" +
                    "        return "+StringUtil.LowerFirst(attribute.getAttributeName())+";\n" +
                    "    }\n";
        }

        return getStr;

    }
    private static String generaSetMethod(JsonSingleModelVO.Attribute attribute){

        String setStr = "";

        if(attribute.getAttributeJavaType() != null){
            setStr = "    public void set"+StringUtil.UpperFirst(attribute.getAttributeName())+"(String "+StringUtil.LowerFirst(attribute.getAttributeName())+") {\n" +
                    "        this."+StringUtil.LowerFirst(attribute.getAttributeName())+" = "+StringUtil.LowerFirst(attribute.getAttributeName())+";\n" +
                    "    }\n";

        }else if(attribute.getJsonSingleModelVO() != null){
            setStr = "    public void set"+attribute.getAttributeName()+"("+attribute.getAttributeName()+" "+StringUtil.LowerFirst(attribute.getAttributeName())+") {\n" +
                    "        this."+StringUtil.LowerFirst(attribute.getAttributeName())+" = "+StringUtil.LowerFirst(attribute.getAttributeName())+";\n" +
                    "    }\n";
        }

        return setStr;
    }

}
