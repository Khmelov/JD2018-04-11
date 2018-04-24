package by.it.tarasiuk.jd01_01.firstapp;

import java.util.Scanner;

// подключение класса не требуется, т.к. класс main
// и класс MyFirstClass находится в одной папке.
// import MyFirstClass;
public class Main {

    public static void main(String[] args) {
        // создаем экземпляр класса
        MyFirstClass myFirstClass=new MyFirstClass();
        //и используем два экземплярных метода
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет мир");
        myFirstClass.printSlogan();
        //покажем аргументы
         PrintArgs printArgs = new PrintArgs(args);
         printArgs.printArgs();
    }
}
