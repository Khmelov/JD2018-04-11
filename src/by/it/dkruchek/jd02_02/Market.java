package by.it.dkruchek.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dmitriy.Kruchek on 5/25/2018.
 */
public class Market {
    static AtomicInteger BuyersCount = new AtomicInteger(0);
    private static List<Thread> allThreads = new ArrayList<>();
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

        for (int i = 1; i < 2; i++) {
            Thread thCashier = new Thread(new Cashier(i));
            thCashier.start();
            allThreads.add(thCashier);
        }

        int buyersNumber =0; // just a label
        while(!Dispatcher.planComplete()) {
                // add from 1 to two buyers
                int count = Util.rnd(0, 2);
                for (int i = 0; !Dispatcher.planComplete() && i < count; i++) {
                    Buyer buyer = new Buyer(++buyersNumber);
                    Dispatcher.addBuyer();
                    allThreads.add(buyer);
                    buyer.start();
                }

            // sleep 1 second
            Util.sleep(1000);
        }
        for (Thread t : allThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The Market is closed...");
    }
}
