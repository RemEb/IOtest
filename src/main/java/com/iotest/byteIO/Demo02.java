package com.iotest.byteIO;

import java.io.*;

public class Demo02 {

    public static void main(String[] args) {
        File dest = new File("D:/Code/Java/IO/src/main/resources/2.txt");

        OutputStream os = null;

        try {
            os = new FileOutputStream(dest, true);
            String str = "hello hello hello \r\n";
            byte[] data = str.getBytes();
            os.write(data, 0, data.length);

            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("write fail");
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e2) {
                System.out.println("close fail");
            }
        }


    }
}
