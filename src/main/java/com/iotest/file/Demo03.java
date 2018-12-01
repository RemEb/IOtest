package com.iotest.file;

import java.io.File;
import java.io.IOException;

/**
 * 常用方法
 * 1、文件名
 * getName() 文件名、路径名
 * getPath() 路径名
 * getAbsoluteFile() 以绝对路径所对应的File对象
 * getAbsolutePath() 绝对路径名
 * getParent() 父目录，相对路径的父目录，可能为null，入，删除本身后的结果
 * 2、判断信息
 * exists() 是否存在
 * canWrite() 文件是否可以写
 * isFile() 是否文件
 * isDirectory() 是否文件夹，没有真实存在的，默认是文件夹
 * isAbsolute() 消除平台差异，以盘符开头，其他以/开头
 * 3、长度
 * length() 字节数，单位为字节。不能读取文件夹的长处
 * 4、创建和删除文件
 * createNewFile() 不存在创建新文件,con系统关键字无法创建
 * delete() 删除文件
 * static createTempFile(前缀3个字节长,后缀默认.temp)  默认临时空间
 * static createTempFIle(前缀3个人字节长，后缀默认.,temp,目录)
 * deleteOnExit() 退出虚拟机删除，常用语删除临时文件。
 */
public class Demo03 {

    public static void main(String[] args) {
        test3();
        //test1();

    }

    public static void test1() {
        // 建立联系
        File src = new File("2t.txt");
        //File src = new File("D:/REMEN/test.png");
        System.out.println(src.getName()); // 返回名称
        System.out.println(src.getPath()); // 如果是绝对路径，返回完成路径，否则相对路径
        System.out.println(src.getAbsolutePath()); // 返回绝对路径
        System.out.println(src.getParent()); // 返回上一级目录,可能为null
    }

    public static void test2() {
        String path = "D:/Code/Java/IO/src/main/resources/test.png";
        File src = new File(path);
        System.out.println("是否存在" + src.exists());
        System.out.println("是否可写" + src.canWrite());
        if (src.isFile()) {
            System.out.println("文件");
        } else {
            System.out.println("文件夹");
        }
        System.out.println("是否是绝对路径" + src.isAbsolute());

        System.out.println("长度" + src.length());
    }

    public static void test3() {
        String path = "D:/Code/Java/IO/src/main/resources/200.png";
        File src = new File(path);
        if (!src.exists()) {
            boolean flag = false;
            try {
                flag = src.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("create file fail");
            }
            System.out.println(flag ? "success" : "fail");
        }
        boolean flag = src.delete();
        System.out.println(flag ? "delete success" : "d false");

        try {
            File temp = File.createTempFile("tes", ".temp", new File("D:/Code/Java/IO/src/main/resources"));
            try {
                // 2s后删除
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 退出即删除
            temp.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
