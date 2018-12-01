package com.iotest.file;

import java.io.File;

/**
 * 两个常亮
 * 1、路径分隔符
 * 2、文件分隔符
 */
public class Demo01 {

    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        // 路径表现形式
        String path = "D:\\REMEM\\lv1111.png";
        path = "D:"+File.separator+"REMEN"+File.separator+"lv1111.png";
        // 推荐方式
        path = "D:/REMEN/lv1111.png";

    }
}
