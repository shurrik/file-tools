package com.shurrik.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by crv on 2015-12-01.
 */
public class FileHelper {
    /** 以行为单位读取文件
     * @param fileName
     * @return
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer content = new StringBuffer();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));

            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                content.append(tempString);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String str = FileHelper.readFileByLines("d:/lib.txt");
        System.out.println(str);
    }
}
