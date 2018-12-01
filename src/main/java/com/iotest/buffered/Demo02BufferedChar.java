package com.iotest.buffered;

import java.io.*;

public class Demo02BufferedChar {
    public static void main(String[] args) {
        File src = new File("D:/Code/Java/IO/src/main/java//com/iotest/charIO/demo01.java");
        File dest = new File("D:/Code/Java/IO/src/main/resources/2copy.txt");

        BufferedReader reader = null;
        BufferedWriter wr = null;

        try {
            reader = new BufferedReader(new FileReader(src));
            wr = new BufferedWriter(new FileWriter(dest));

            String line = null;
            while (null != (line = reader.readLine())) {
                wr.write(line);
                wr.newLine();
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
