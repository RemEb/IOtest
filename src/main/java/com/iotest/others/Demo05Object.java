package com.iotest.others;

import java.io.*;

public class Demo05Object {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        seri("D:/Code/Java/IO/src/main/resources/2.txt");

        read("D:/Code/Java/IO/src/main/resources/2.txt");
    }

    /**
     * 序列化
     * @param destPath
     * @throws IOException
     */
    public static void seri(String destPath) throws IOException {
        Employee emp = new Employee("aaa", 5000);

        File dest = new File(destPath);
        // 选择流
        ObjectOutputStream dos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );
        // 操作 写出的顺序  为读取做准备
        dos.writeObject(emp);

        dos.flush();
        dos.close();
    }

    public static void read(String destPath) throws IOException, ClassNotFoundException {
        File src = new File(destPath);
        ObjectInputStream dis = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)
                )
        );

        // 操作 读取顺序与写出一直 必须存在才能读取
        Object obj = dis.readObject();
        if (obj instanceof Employee){
            Employee emp =(Employee)obj;
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
        }

        dis.close();
    }
}
