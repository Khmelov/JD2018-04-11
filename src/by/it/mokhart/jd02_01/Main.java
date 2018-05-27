package by.it.mokhart.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Buyer> allBuyers = new ArrayList<>();

    public static void main(String[] args) {
        int customer = 0;
        System.out.println("Shop is opened.");
        for (int time = 0; time < 120; time++) {
            int count = 1 + (int) Math.random() * 3;
            for (int i = 0; i < count; i++) {
                customer = customer + 1;
                Buyer buyer = new Buyer(customer);
                allBuyers.add(buyer);
                buyer.start();
            }
        }
        for (Buyer buyer : allBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Shop is closed.");
    }
}
