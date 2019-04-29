package com.example.mybatisplusdemo.jvmext;

import java.io.FileInputStream;
import java.io.InputStream;

public class HotCodeTest {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("F:\\code\\my_project\\mybatis-study-demon\\mybatis-plus-demo\\target\\classes\\com\\example\\mybatisplusdemo\\test\\TestClass.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();

        System.out.println(JavaClassExecuter.execute(b));
    }
}
