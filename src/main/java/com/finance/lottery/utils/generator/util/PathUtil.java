package com.finance.lottery.utils.generator.util;

import org.springframework.core.io.DefaultResourceLoader;

import java.io.File;
import java.io.IOException;

/**
 * <B>Description:</B> 路径工具类 <br>
 * <B>Create on:</B> 2018/5/5 上午11:26 <br>
 *
 * @author xiangyu.ye
 * @version 1.0
 */
public class PathUtil {
    /**
    * <B>Description:</B> 获取工程路径 <br>
    * <B>Create on:</B> 2018/5/5 上午11:21 <br>
    * @return /Users/jerryye/backup/studio/AvailableCode/web/freemarker/freemarker_demo
    * @author xiangyu.ye
    */
    public static String getProjectPath()   {
        // 获取文件分隔符
        String separator = File.separator;
        // 获取工程路径
        File projectPath = null;
        try {
            projectPath = new DefaultResourceLoader().getResource("").getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //F:\backup\studio\AvailableCode\framework\freemarker\jeesite_hibernate\src\main\webapp\WEB-INF\classes
//        System.out.println(projectPath);
        while (!new File(projectPath.getPath() + separator + "src" + separator + "main").exists()) {
            projectPath = projectPath.getParentFile();
        }

        //Project Path: {}F:\backup\studio\AvailableCode\framework\freemarker\jeesite_hibernate
        //        System.out.println("Project Path: {}" + projectPath);
        return projectPath.getPath();
    }
}
