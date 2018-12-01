package com.iotest.buffered;

import java.io.*;

/**
 * 文件拷贝+缓冲流
 * 提高性能
 */
public class Demo01BufferedByte {
    public static void main(String[] args) {
        File src = new File("D:/Code/Java/IO/src/main/resources/test.png");
        File dest = new File("D:/Code/Java/IO/src/main/resources/1020.png");
        try {
            copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File src, File dest) throws IOException {
        if (!src.isFile()) {
            System.out.println("only file");
            throw new IOException("only file");
        }
        // 建立联系 源（存在且为文件） + 目的地（文件可以不存在）
        // 选择流
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
        if (!src.isFile()) {
            System.out.println("only file");
        }
        // 文件拷贝 循环+读取+写出
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            os.write(flush, 0, len);
        }
        os.flush();

        os.close();
        is.close();
    }
}
