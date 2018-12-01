package com.iotest.file;

import java.io.File;

/**
 * 相对路径与绝对路径构造File对象
 */
public class Demo02 {
    /**
     *
     */
    public static void main(String[] args) {
        String parentPath = "D:/REMEN";
        String name = "test.png";
        // 相对路径
        File src = new File(parentPath, name);
        src = new File(new File(parentPath), name);
        // out
        System.out.println(src.getName());
        System.out.println(src.getPath());


        // 绝对路径
        src = new File("D:/REMEN/test.png");
        // out
        System.out.println(src.getName());
        System.out.println(src.getPath());

        // 没有盘符 以user.dir构建
        src = new File("text.png");
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());


    }
}
