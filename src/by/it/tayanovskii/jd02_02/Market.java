package by.it.tayanovskii.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Thread> allThreads = new ArrayList<>();


    public static void main(String[] args) {
        int number = 0;
        Goods goods = new Goods();
        //int countCashires=1;

        for (int i = 1; i <= 4; i++) {
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
