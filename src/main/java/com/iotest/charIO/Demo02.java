package com.iotest.charIO;

import java.io.*;

public class Demo02 {
    public static void main(String[] args) {
        File src = new File("D:/Code/Java/IO/src/main/resources/2.txt");
        File dest = new File("D:/Code/Java/IO/src/main/resources/2copy.txt");

        Reader reader = null;
        Writer wr = null;

        try {
            reader = new FileReader(src);
            wr = new FileWriter(dest);

            char[] flush = new char[10];
            int len = 0;
            while (-1 != (len = reader.read(flush))) {
                wr.write(flush,0,len);
            }

            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (wr != null) {
                try {
                    wr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
