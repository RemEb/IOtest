package com.iotest.others;

import java.io.*;

public class Demo04Data {
    public static void main(String[] args) throws IOException {
        byte[] data = write();
        read(data);
    }

    /**
     * 数据+类型输出到字节数组中
     * @return
     * @throws IOException
     */
    public static byte[] write() throws IOException {
        // 目标数组
        byte[] dest = null;
        double point = 2.6;
        long num = 199L;
        String str = "hello world";

        // 选择流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        bos
                )
        );
        // 操作 写出的顺序  为读取做准备
        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);
        dos.flush();

        dest = bos.toByteArray();

        dos.close();

        return dest;
    }

    /**
     * 从字节数组读取数据+类型
     * @param src
     */
    public static void read(byte[] src) throws IOException {

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(src)
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
