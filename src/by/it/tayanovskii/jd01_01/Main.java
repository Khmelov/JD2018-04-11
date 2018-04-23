package by.it.tayanovskii.jd01_01;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hello hello=new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет мир!");
        hello.printSlogan();

        Args argObject = new Args();
        argObject.setArgs(args);
        argObject.printArgs();


    }
}
