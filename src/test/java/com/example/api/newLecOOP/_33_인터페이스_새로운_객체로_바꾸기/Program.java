package com.example.api.newLecOOP._33_인터페이스_새로운_객체로_바꾸기;

import org.apache.ibatis.type.Alias;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

@Alias("ver33Program")
public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        FileInputStream fis = new FileInputStream("src\\test\\java\\com\\example\\api\\newLecOOP\\_33_인터페이스_새로운_객체로_바꾸기\\setting.txt");
        Scanner scan = new Scanner(fis);

        String className = scan.nextLine();
        scan.close();
        fis.close();

        // Class 정보를 알아낸다.
        Class clazz = Class.forName(className);
        A a = new A();
        X x = (X) clazz.newInstance();
        a.setX(x);

        a.print();
    }
}
