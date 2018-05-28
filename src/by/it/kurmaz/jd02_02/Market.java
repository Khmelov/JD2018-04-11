package by.it.kurmaz.jd02_02;

import java.util.LinkedList;
import java.util.List;

public class Market {

    static final Integer monitor = 0;

    static List<Buyer> list = new LinkedList<>();
    static List<Thread> allThreads = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Shop is opened");
        Goods.createBucket();
        System.out.println("Bucket is created");

        for (int i = 1; i < 3; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashier.start();
            allThreads.add(cashier);
        }

        int counter = 0;
        boolean isOld;

        while (!dispatch.planComplete()) {
                int count = Util.getRandom(1, 2);
                for (int j = 0; j < count; j++) {
                    isOld = ((Util.getRandom(1, 4)) % 4 == 0);
                    Buyer buyer = new Buyer("Buyer # " + counter, isOld);
                    synchronized (Market.monitor) {
                        Market.list.add(buyer);
                    }
                    buyer.start();
                    counter++;
                }
                Util.sleep(1000, false);
            }

        while (list.size() != 0)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("Shop closed");
    }
}
