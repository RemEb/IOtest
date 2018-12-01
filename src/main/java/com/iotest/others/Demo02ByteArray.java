package com.iotest.others;



import java.io.*;

public class Demo02ByteArray {

    public static void main(String[] args) throws IOException {
        byte[] data = getBytesFromFile(
                "D:/Code/Java/IO/src/main/resources/test.png"
        );
        toFileFromByteArray(data,"D:/Code/Java/IO/src/main/resources/2test.png");
        //System.out.println(new String(data));
    }

    /**
     * 文件内容 --程序--> 字节数组
     * @return
     */
    public static byte[] getBytesFromFile(String srcPath) throws IOException {
        // 创建文件源
        File src = new File(srcPath);
        // 创建目的地
        byte[] dest = null;

        // 选择流
        // 文件输入流
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        // 字节数组输出流 不能使用多态、
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //操作 不断读取文件 写出到字节数组流中
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            bos.write(flush, 0, len);
        }
        bos.flush();

        // 获取资源
        dest = bos.toByteArray();
        is.close();

        return dest;
    }

    /**
     * 字节数组 --程序--> 文件
     * @param src
     * @param destPath
     */
    public static void toFileFromByteArray(byte[] src,String destPath) throws IOException{
        // 创建源
        // 创建目的地
        File dest = new File(destPath);
        //选择流
        //字节数组输入流
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
        //文件输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
        //操作 不断读取字节数组
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            os.write(flush, 0, len);
        }
        os.flush();

        // 释放资源
        os.close();
        is.close();
    }

}
