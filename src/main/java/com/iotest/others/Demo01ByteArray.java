package com.iotest.others;

import java.io.*;

public class Demo01ByteArray {

    public static void main(String[] args) {
        try {
            read(write());
        } catch (IOException e) {
            System.out.println("error");
        }


    }

    public static void read(byte[] src) throws IOException {
        // 数据源传入

        // 选择流
        InputStream is = new BufferedInputStream(
                new ByteArrayInputStream(
                        src
                )
        );
        // 操作
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len=is.read(flush))) {
            System.out.println( new String(flush,0,len));
        }
        is.close();
    }

    public static byte[] write() throws IOException {
        // 目的地
        byte[] dest;
        // 不同点
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 操作写出
        String msg = "操作与文件输入流操作一致";
        byte[] info = msg.getBytes();
        bos.write(info,0,info.length);
        // 获取数据
        dest = bos.toByteArray();
        // 释放资源
        bos.close();
        return dest;
    }
}
