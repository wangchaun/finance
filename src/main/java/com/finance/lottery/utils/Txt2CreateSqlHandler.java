package com.finance.lottery.utils;

import com.finance.lottery.utils.generator.util.PathUtil;
import com.finance.lottery.utils.generator.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @program: finance
 * @description:
 * @author: siming.wang
 * @create: 2019-10-29 11:07
 **/

public class Txt2CreateSqlHandler {

    private static final String FILE_DIR = "/Users/wangsiming/Desktop/";

    public static void main(String[] args) throws Exception{
        String tableName = "provider_contract";
        String tableNameCn = "供应商合同表";

        FileReader file = new FileReader(FILE_DIR + tableName +  ".txt");
        BufferedReader br = new BufferedReader(file);

        StringBuffer sb = new StringBuffer();

        sb.append("CREATE TABLE `t_"+tableName+"` (");
        sb.append("\r\n");
        sb.append("  `sys_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Id',");
        sb.append("\r\n");

        String line = br.readLine();
        while (line != null){

            if (StringUtils.isBlank(line) || line.contains("#") || getfiledStr(line).equals("choices")){
                line = br.readLine();
                continue;
            }

            sb.append("  `"+getfiledStr(line)+"` ")
                    .append(getSqlType(line)).append(" COLLATE utf8mb4_bin DEFAULT NULL COMMENT ")
                    .append(""+getComment(line)+"',")
                    .append("\r\n");

            line = br.readLine();
        }


        sb.append("  `yn` char(1) COLLATE utf8mb4_bin NOT NULL COMMENT '是否有效',\n" +
                "  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',\n" +
                "  `create_time` datetime NOT NULL COMMENT '创建时间',\n" +
                "  `create_pin` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '创建人',\n" +
                "  `update_pin` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '更新人',\n" +
                "  `versions` bigint(20) NOT NULL DEFAULT '0' COMMENT '版本号',\n" +
                "  PRIMARY KEY (`sys_no`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='"+tableNameCn+"'");


        System.out.println(sb.toString());


    }


    private static String getfiledStr(String line){
        if (line == null){
            return "";
        }
        return line.substring(0, line.indexOf("=")).trim();
    }

    private static String getComment(String line){
        if (line == null){
            return "";
        }

        String comment = "'";
        try {
            if (line.contains("verbose_name")){
                comment = line.substring(line.indexOf("verbose_name=u")+14, line.lastIndexOf("'"));
            }else if (line.contains("verbose")){
                comment = line.substring(line.indexOf("verbose")+9, line.lastIndexOf("'"));
            }
        }catch (Exception e){

        }

        return comment;
    }

    private static String getSqlType(String line){
        if (line == null){
            return "";
        }

        if (line.contains("StringField") || line.contains("ListField")){
            return "varchar(64)";
        }
        if (line.contains("IntField")){
            return "tinyint(4)";
        }
        if (line.contains("BooleanField")){
            return "char(1)";
        }
        if (line.contains("BooleanField")){
            return "char(1)";
        }
        if (line.contains("FloatField")){
            return "decimal(32,2) DEFAULT '0.00'";
        }


        return "varchar(64)";
    }

}
