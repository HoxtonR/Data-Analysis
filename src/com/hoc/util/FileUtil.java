package com.hoc.util;

import java.io.*;

public class FileUtil {
    //覆盖原有文件内容写入
    public static void writeFile(String content, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //在原有文件内容后追加
    public static void appendFile(String content, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取文件内容
    public static String dataReader(String pathname) throws IOException {
        File file = new File(pathname);
        BufferedReader reader = null;
        StringBuilder b = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                b.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return b.toString();
    }



}
