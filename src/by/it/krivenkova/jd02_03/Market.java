package by.it.krivenkova.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Thread> allBuyers=new ArrayList<>();


    public static void main(String[] args) {
        int number=0;
        System.out.println("Магазин открыт");

        for (int i = 1; i <= 2; i++) {
            Thread thCasier = new Thread(new Cashier(i));
            thCasier.start();
            allBuyers.add(thCasier);
        }

        while (!Dispatcher.planComplete()) {
            int count = Util.rnd(0, 5);
            for (int i = 0; !Dispatcher.planComplete() && i < count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispatcher.addBuyer();
                allBuyers.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }



       /* for (int time = 0; time < 120; time++) {
            int count=Util.rnd(0,2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                allBuyers.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }*/
        for (Thread buyer : allBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
