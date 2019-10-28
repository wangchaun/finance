package com.finance.lottery.utils;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.finance.lottery.module.StudentGrade;
import com.finance.lottery.utils.generator.util.PathUtil;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: finance
 * @description:
 * @author: siming.wang
 * @create: 2019-10-28 18:45
 **/

public class Txt2ExcelHandler {
    private static final String FILE_DIR = "/Users/wangsiming/Desktop/";

    public static void main(String[] args)throws Exception {

        String title = "护士";

        ExcelWriter writer = ExcelUtil.getWriter(FILE_DIR + title + ".xlsx");
        FileReader file = new FileReader(
                PathUtil.getProjectPath() + "/src/main/resources/txt/" + title +  ".txt");

        BufferedReader br = new BufferedReader(file);

        String line = br.readLine();

        System.out.println(line);

        int i = 1;
        List<StudentGrade> studentGradeList = new ArrayList<>();
        while (line != null){
            StudentGrade studentGrade = new StudentGrade();
            line = line.substring(String.valueOf(i).length());
            String name = line.substring(0, line.length() - 3);

            String grade = line.replace(name, "");

            studentGrade.setRowNumber(i++ + "");
            studentGrade.setGrades(grade);
            studentGrade.setStudentName(name);

            studentGradeList.add(studentGrade);

            line = br.readLine();
        }

        writer.addHeaderAlias("rowNumber", "序号");
        writer.addHeaderAlias("studentName", "姓名");
        writer.addHeaderAlias("grades", "分数");
        writer.merge(2, title+"成绩单");
        writer.write(studentGradeList, true);

        writer.close();


    }
}
