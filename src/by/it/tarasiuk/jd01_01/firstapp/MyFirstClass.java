package by.it.tarasiuk.jd01_01.firstapp;
/**
 * Класс с двумя методами
 */
public class MyFirstClass {
    //объявление члена класса, который хранит содержимое слогана
    private String slogan="Hello, world!";

    //метод установки нового значения слогана
    public void setSlogan(String slogan) { this.slogan=slogan; }

    // определение метода вывода слогана на устройство
    // в данном случае консоль
    void printSlogan() { System.out.println(this.slogan); }
}
