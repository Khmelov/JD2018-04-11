package by.it.mokhart.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static List<Thread> allThreads = new ArrayList<>();

    public static void main(String[] args) {
        int numberOfBuyers = 0;
        int numberOfCashiers = 0;
        System.out.println("Магазин открыт");

        Thread thCashier = new Thread(new Cashier(++numberOfCashiers));
        thCashier.start();
        allThreads.add(thCashier);

        while (!Dispetcher.planComplete()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispetcher.planComplete() && i < count; i++) {
                Buyer buyer = new Buyer(++numberOfBuyers);
                Dispetcher.addBuyer();
                allThreads.add(buyer);
                buyer.start();
            }
            if (((BuyerQueue.getSizeQueue() / numberOfCashiers) > 5) && numberOfCashiers < 5) {
                Thread anotherOneCashier = new Thread(new Cashier(++numberOfCashiers));
                allThreads.add(anotherOneCashier);
                anotherOneCashier.start();
            }
            Util.sleep(1000);
        }
        for (Thread t : allThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
