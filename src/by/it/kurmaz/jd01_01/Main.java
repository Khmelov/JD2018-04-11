package by.it.kurmaz.jd01_01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setSlogan("Shalom!");
        hello.printSlogan();
        Args argsObject = new Args();
        argsObject.showArgs(args);
    }
}
