package by.it.sharin.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Thread> allThreads = new ArrayList<>();


    public static void main(String[] args) {
        int number = 0;
        System.out.println("Магазин открыт");


        for (int i = 1; i <= 2; i++) {
            Thread thCasier = new Thread(new Cashier(i));
            thCasier.start();
            allThreads.add(thCasier);
        }


        while (!Dispatcher.planComplete()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispatcher.planComplete() && i < count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispatcher.addBuyer();
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
        System.out.println("Магазин закрыт");
    }
}
