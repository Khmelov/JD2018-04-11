package by.it.rogov.jd02_02;

public class Cashiers implements Runnable {

    private int number;
    private String name;

    Cashiers(int number) {
        this.number = number;
        name = "Кассир №" + number;

    }

    @Override
    public void run() {
        System.out.println(name + " открыл кассу");

        System.out.println(name + "закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
