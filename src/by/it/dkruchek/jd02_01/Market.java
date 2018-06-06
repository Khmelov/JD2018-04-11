package by.it.dkruchek.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dmitriy.Kruchek on 5/25/2018.
 */
public class Market {
    static AtomicInteger BuyersCount = new AtomicInteger(0);
    private static List<Buyer> allBuyers = new ArrayList<>();
    static HashMap<String, Double> goods;
    static {
        goods = new HashMap<>();
        goods.put("Milk", 1.1);
        goods.put("Bread", 2.1);
        goods.put("Meat", 7.9);
        goods.put("Apple", 0.24);
        goods.put("Tomato", 0.33);
        goods.put("Potato", 0.1);
        goods.put("Egg", 0.15);
    }

    public static void main(String[] args) {
        System.out.println("The Market is open...");
        int buyersNumber =0; // just a label
        for (int time = 0; time < 120; time++) {
            int t = time % 60; // get current second of each minute;
            while (t < 30 ? BuyersCount.get() <= t + 10 : BuyersCount.get() <= 40 + 30 - t) {
                // add from 1 to two buyers
                int count = Util.rnd(0, 2);
                for (int i = 0; i < count; i++) {
                    Buyer buyer = new Buyer(++buyersNumber);
                    allBuyers.add(buyer);
                    buyer.start();
                }
            }
            // sleep 1 second
            Util.sleep(1000);
            System.out.println("--------------------------------");
            System.out.println("second " + t + "--" + BuyersCount.get());
        }
        for (Buyer buyer : allBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The Market is closed...");
    }
}
