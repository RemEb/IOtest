package com.iotest.charIO;

import java.io.*;

public class Demo01 {
    public static void main(String[] args) {
        File src = new File("D:/Code/Java/IO/src/main/resources/2.txt");

        Reader reader =null;

        try {
            reader = new FileReader(src);
            char[] flush = new char[10];
            int len  =0 ;
            while (-1 != (len = reader.read(flush))) {
                String str = new String(flush,0,len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("read fail");
        }finally {
            if (null!=reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
