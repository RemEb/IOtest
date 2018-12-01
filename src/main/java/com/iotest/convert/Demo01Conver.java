package com.iotest.convert;

import java.io.UnsupportedEncodingException;

/**
 * 解码与编码字符集必须相统一
 * 否则乱码
 */
public class Demo01Conver {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 解码 byte --> char
        String str = "中国中国";
        // 编码 char --> byte
        byte[] data = str.getBytes();
        // 编码与解码字符集统一
        System.out.println(new String(data));
        data = str.getBytes("GBK");
        System.out.println(new String(data));

        str = new String("中国".getBytes("GBK"),"GBK");
        System.out.println(str);
    }
}
