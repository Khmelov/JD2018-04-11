package by.it.kurmaz.jd02_02;

public class Cashier implements Runnable {

    private int number;
    private String name;

    Cashier(int number) {
        this.name = "Cashier # " + number;
        this.number = number;
    }

    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Cashier " + name + " is opened");

    }
}
