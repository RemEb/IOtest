package com.iotest.byteIO;

import java.io.File;
import java.io.IOException;

public class Demo04CopyDir {

    public static void main(String[] args) {
        // 源目录
        String srcPath = "D:/Code/Java/IO/src/main/resources/testfile";
        // 目标目录
        String destPath = "D:/Code/Java/IO/src/main/resources/test";

        File src = new File(srcPath);
        File dest = new File(destPath);
        copyDir(src,dest);
    }

    /**
     * 拷贝文件夹
     * @param src 源File对象
     * @param dest 目标File对象
     */
    public static void copyDir(File src, File dest) {
        if (src.isDirectory()) {
            dest = new File(dest,src.getName());
            if (dest.getAbsolutePath().contains(src.getAbsolutePath())) {
                System.out.println("不能将父目录的文件复制到子目录");
                return ;
            }
        }
        copyDirDetail(src,dest);
    }


    /**
     * 拷贝文件夹细节
     * @param src
     * @param dest
     */
    private static void copyDirDetail(File src, File dest) {
        if (src.isFile()){
            try {
                Demo03CopyFile.copyFile(src,dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (src.isDirectory()) {
            // 确保目标文件夹存在
            dest.mkdirs();
            // 获取下一级目录|文件
             for (File sub:src.listFiles()) {
                 copyDirDetail(sub,new File(dest,sub.getName()));
             }
        }
    }
}
