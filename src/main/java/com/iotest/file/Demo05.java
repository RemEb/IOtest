package com.iotest.file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级目录-文件的名称
 * 1、listFiles()
 * 2、递归
 */
public class Demo05 {
    public static void main(String[] args) {
        String path = "D:/Code/Java/IO/src/main/resources";
        File parent = new File(path);
        //printName(parent);

        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));

    }

    public static void printName(File src) {
        if (null == src || !src.exists()){
            return;
        }
        System.out.println(src.getAbsolutePath());
        if (src.isDirectory()) {
            for (File sub:src.listFiles()){
                printName(sub);
            }
        }
    }
}
