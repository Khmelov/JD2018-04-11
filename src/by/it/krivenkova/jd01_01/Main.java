package by.it.krivenkova.jd01_01;

import java.util.Scanner;

public class Main {
    /* public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Hello world");
           Args argsObject = new Args();
           argsObject.showArgs(args);

       }*/
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет мир");
        hello.printSlogan();
        Args argObj = new Args(args);
        argObj.printArgs();
    }
}
