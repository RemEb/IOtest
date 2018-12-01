package com.iotest.others;

import java.io.*;

/**
 * 数据类型（基本字符类型+String）处理流
 */
public class Demo03Data {

    public static void main(String[] args) throws IOException {
        write("D:/Code/Java/IO/src/main/resources/2.txt");
        read("D:/Code/Java/IO/src/main/resources/2.txt");
    }

    /**
     * 数据+类型输出到文件
     * @param destPath
     * @throws IOException
     */
    public static void write(String destPath) throws IOException {
        double point = 2.6;
        long num = 199L;
        String str = "hello world";
        // 创建源
        File dest = new File(destPath);
        // 选择流
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );
        // 操作 写出的顺序  为读取做准备
        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);

        dos.flush();
        dos.close();
    }

    /**
     * 从文件读取数据+类型
     * @param destPath
     */
    public static void read(String destPath) throws IOException {
        File src = new File(destPath);
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)
                )
        );

        // 操作 读取顺序与写出一直 必须存在才能读取
        double num1 = dis.readDouble();
        long num2 = dis.readLong();
        String str2 = dis.readUTF();

        dis.close();

        System.out.println(str2);
    }


}
