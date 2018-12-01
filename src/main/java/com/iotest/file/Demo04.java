package com.iotest.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 5、操作目录
 *  mkdir() 创建目录 必须确保父目录存在 如果不存在则创建失败
 *  mkdirs() 创建目录 如果父目录不存在 一同创建
 *  list() 子目录-文件名 字符串形式
 *  listFiles() 子目录-文件file对象 file形式;后可以加filter过滤器
 *  static listRoots() 根路径
 *
 */
public class Demo04 {

    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1() {
        String path = "D:/Code/Java/IO/src/main/resources/testfile/test";
        File src = new File(path);
        //src.mkdir();
        src.mkdirs();
    }
    public static void test2(){

        String path = "D:/Code/Java/IO/src/main/resources";
        File src = new File(path);
        System.out.println("=========子目录-文件名=========");
        if (src.isDirectory()){
            String[] subNames = src.list();
            for (String temp:subNames){
                System.out.println(temp);
            }
        }
        System.out.println("=========子目录-文件File对象=========");
        if (src.isDirectory()){
            File[] subFiles = src.listFiles();
            for (File temp:subFiles){
                System.out.println(temp.getAbsolutePath());
            }
        }
        System.out.println("=========子目录-.java对象=========");
        if (src.isDirectory()){
            File[] subFiles = src.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".java");
                }
            });
            for (File temp:subFiles){
                System.out.println(temp.getAbsolutePath());
            }
        }
    }
}
