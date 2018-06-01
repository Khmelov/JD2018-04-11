package by.it.zakharenko.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    static List<Thread> allThreads = new ArrayList<>();
    static int countCashier = 0;

    public static void main(String[] args) {
        int number = 0;
        System.out.println("Магазин открыт");

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            executor.execute(new Cashier(i));
            //Thread thCasier = new Thread(new Cashier(i));
            //thCasier.start();
            //allThreads.add(thCasier);
            //countCashier++;
        }
        executor.shutdown();

        while (!Dispetcher.planComplete()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispetcher.planComplete() && i < count; i++) {
                //Buyer buyer = new Buyer(++number);
                Dispetcher.addBuyer();
                new Buyer(++number).start();
                //allThreads.add(buyer);
                //buyer.start();
            }
            if ((Math.ceil(BuyerQueue.getSizeQueue() / 5) > countCashier) && countCashier < 5) {
                Thread thCasier = new Thread(new Cashier(++countCashier));
                thCasier.start();
                allThreads.add(thCasier);
            }

            Util.sleep(1000);
        }

        while (!executor.isTerminated())
            Util.sleep(50);
        System.out.println("Магазин закрыт");

        /*for (int time = 0; time < 120; time++) {    //в течение двух минут
            int count = Util.rnd(0, 2);     //в магазин приходят от 0 до 2 новых покупателей
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                allThreads.add(buyer);
                buyer.start();  //запуск потока
            }
            Util.sleep(1000);    //выполнение потока приостановлено на 1 секунду (1000 миллисекунд), метод от имени класса Util
            if ((Math.ceil(BuyerQueue.getSizeQueue() / 5) > countCashier) && countCashier < 5) {
                Thread thCasier = new Thread(new Cashier(++countCashier));
                thCasier.start();
                allThreads.add(thCasier);
            }
        }

        for (Thread t : allThreads) {
            try {
                t.join();   //приостановка потока, пока другой не завершит свою работу
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");*/
    }
}
