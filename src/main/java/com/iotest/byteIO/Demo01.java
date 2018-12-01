package com.iotest.byteIO;

import java.io.*;

public class Demo01 {
    /**
     * 文件的读取2
     * @param args
     */
    public static void main(String[] args) {
        File src = new File("D:/Code/Java/IO/src/main/resources/2.txt");

        InputStream is = null;
        try {
            is = new FileInputStream(src);
            byte[] car = new byte[10];
            int len = 0;
            while ((len = is.read(car)) != -1) {
                String info = new String(car, 0, len);
                System.out.println(info);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("read fail");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("file close");
            }
        }
    }
}

