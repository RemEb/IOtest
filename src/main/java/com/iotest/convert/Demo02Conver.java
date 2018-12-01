package com.iotest.convert;

import java.io.*;

public class Demo02Conver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(new File("D:/Code/Java/IO/src/main/resources/2copy.txt")),"UTF-8")
        );
        String info = null;
        while (null!= (info=br.readLine())) {
            System.out.println(info);
        }

        br.close();
    }
}
