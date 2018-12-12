package com.finance.lottery.web;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * @program: finance
 * @description:
 * @author: siming.wang
 * @create: 2018-09-29 11:22
 **/

public class PdfController {
    private static final String FILE_DIR = "/Users/wangsiming/Desktop/";


    public static void main(String[] args) throws Exception {

//        qieFY(4);

        combine("/Users/wangsiming/Desktop/发货清单.pdf","/Users/wangsiming/Desktop/发货清单.pdf");
    }

    /**
     *
     * 功能描述: 将file2合并到file1
     *
     * @param: 
     * @return: 
     * @auther: siming.wang
     * @date: 18/12/12 下午4:35
     */
    public static void combine(String file1, String file2) throws Exception{
        PdfReader reader1 = new PdfReader(file1);
        PdfReader reader2 = new PdfReader(file2);

        int pageTotal1 = reader1.getNumberOfPages();
        int pageTotal2 = reader2.getNumberOfPages();


        Document oddDoc = new Document();
        PdfWriter writer = PdfWriter.getInstance(oddDoc, new FileOutputStream(FILE_DIR+"combine.pdf"));
        oddDoc.open();
        PdfContentByte cb = writer.getDirectContent();

        for(int i = 0; i<pageTotal1; i++){
            oddDoc.newPage();
            cb.addTemplate(writer.getImportedPage(reader1, i+1), 0, 0);

        }
        for(int i = 0; i<pageTotal2; i++){
            oddDoc.newPage();
            cb.addTemplate(writer.getImportedPage(reader2, i+1), 0, 0);

        }

        oddDoc.close();
        writer.close();

    }




    /**
     * 切分页
     */
    public static void qieFY(int fenye) throws Exception{
        PdfReader reader = new PdfReader(FILE_DIR + ".pdf");

        int pageTotal = reader.getNumberOfPages();

        int totalPage = pageTotal/fenye;

        boolean flag = pageTotal%fenye != 0;

        int page = 0;

        for(int i = 0; i<totalPage; i++){

            Document oddDoc = new Document();
            PdfWriter writer = PdfWriter.getInstance(oddDoc, new FileOutputStream(FILE_DIR + "_"+i+".pdf"));
            oddDoc.open();
            PdfContentByte cb = writer.getDirectContent();

            for (int j = 1; j<=fenye; j++){
                oddDoc.newPage();
                cb.addTemplate(writer.getImportedPage(reader, j+page), 0, 0);
            }
            page += fenye;
            oddDoc.close();
            writer.close();

        }

        if (flag){
            Document oddDoc = new Document();
            PdfWriter writer = PdfWriter.getInstance(oddDoc, new FileOutputStream(FILE_DIR + "_"+totalPage+".pdf"));
            oddDoc.open();
            PdfContentByte cb = writer.getDirectContent();
            for (int j = 1; j<=pageTotal%fenye; j++){
                oddDoc.newPage();
                cb.addTemplate(writer.getImportedPage(reader, j+page), 0, 0);
            }
            oddDoc.close();
            writer.close();

        }

    }


    /**
     * 切奇偶
     */

    public static void qieQO() throws Exception{
        PdfReader reader = new PdfReader(FILE_DIR + ".pdf");

        int pageTotal = reader.getNumberOfPages();

        Document oddDoc = new Document();
        PdfWriter writer = PdfWriter.getInstance(oddDoc, new FileOutputStream(FILE_DIR + "_Odd.pdf"));
        oddDoc.open();
        PdfContentByte cb = writer.getDirectContent();

        Document evenDoc = new Document();
        PdfWriter writer2 = PdfWriter.getInstance(evenDoc, new FileOutputStream(FILE_DIR + "_Even.pdf"));
        evenDoc.open();
        PdfContentByte cb2 = writer2.getDirectContent();

        for (int i = 1; i <= pageTotal; i++) {
            if (i % 2 != 0) {
                //奇数页
                oddDoc.newPage();
                cb.addTemplate(writer.getImportedPage(reader, i), 0, 0);

            }

        }
        for (int i = pageTotal; i >= 1; i--) {
            //偶数页
            if (i % 2 == 0) {
                evenDoc.newPage();
                cb2.addTemplate(writer2.getImportedPage(reader, i), 0, 0);
            }
        }

        oddDoc.close();
        writer.close();
        evenDoc.close();
        writer2.close();
    }
}

