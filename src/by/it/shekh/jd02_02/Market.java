package by.it.shekh.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Buyer> allBuyers = new ArrayList<>();
    static List<Thread> allThreads = new ArrayList<>();


    public static void main(String[] args) {
        int number = 0;
        System.out.println("Магазин открыт");

        for (int i = 1; i <= 2; i++) {
            Thread thCashier = new Thread(new Cashier(i));
            thCashier.start();
            allThreads.add(thCashier);
        }

        Goods.addGoodsToShop();


        while (!Dispetcher.planComplete()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispetcher.planComplete() && i < count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispetcher.addBuyer();
                allThreads.add(buyer);
                buyer.start();
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
//        for (Buyer buyer : allBuyers) {
//            try {
//                buyer.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("Магазин закрыт");
    }
}
