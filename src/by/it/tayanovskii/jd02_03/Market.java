package by.it.tayanovskii.jd02_03;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {


    public static void main(String[] args) {
        int number = 0;
        int time = 0;
        int second;
        Goods goods = new Goods();
        System.out.println("Магазин открыт");

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            executor.execute(new Cashier(i));
        }
        executor.shutdown();

//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        int numberCashier = 1;
//        while (!Dispatcher.planComplete() && numberCashier<=5) {
//            if(BuyerQueue.getSizeofBuyerQueue() >=numberCashier*5) {
//                executor.execute(new Cashier(numberCashier++));
//            }
//            else Util.sleep(100);
//
//        }
//        executor.shutdown();


//        for (int time = 0; time < 120; time++){
//            int minute = time % 60;
//            int count = Util.rnd(0, 2);
//            if (minute <= 30 && countBuyersInShop >= (minute + 10)) {
//                for (int i = 0; i < count; i++) {
//                    Buyer buyer = new Buyer(++number);
//                    allBuyers.add(buyer);
//                    countBuyersInShop++;
//                    buyer.start();
//                }
//            } else if (minute > 30 && countBuyersInShop <= 40 + (30 - minute)) {
//                for (int i = 0; i < count; i++) {
//                    Buyer buyer = new Buyer(++number);
//                    allBuyers.add(buyer);
//                    countBuyersInShop++;
//                    buyer.start();
//                }
//            } else {
//                Util.sleep(1);
//
//            }
//
//        }
//


        while (!Dispatcher.planComplete()) {
            second = time % 60;
            int count = Util.rnd(0, 2);
            if (second <= 30 && Dispatcher.countBuyerInShop.intValue() < (second + 10)) {
                for (int i = 0; !Dispatcher.planComplete() && i < count; i++) {
                    Dispatcher.addBuyer();
                    new Buyer(++number).start();
                }
            } else if (second > 30 && Dispatcher.countBuyerInShop.intValue() < 40 + (30 - second)) {
                for (int i = 0; !Dispatcher.planComplete() && i < count; i++) {
                    Dispatcher.addBuyer();
                    new Buyer(++number).start();
                }
            } else {
                Util.sleep(10);
            }
            time++;
            Util.sleep(1000);
        }



        while (!executor.isTerminated())
            Util.sleep(50);
        System.out.println("Магазин закрыт");
    }
}
