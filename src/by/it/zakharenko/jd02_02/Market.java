package by.it.zakharenko.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Thread> allThreads = new ArrayList<>();

    public static void main(String[] args) {
        int number = 0;
        System.out.println("Магазин открыт");

        for (int i = 0; i <= 2; i++) {
            Thread thCasier = new Thread(new Cashier(i));
            thCasier.start();
            allThreads.add(thCasier);
        }

        while (!Dispetcher.planComplete()) {
            int count = Util.rnd(0, 5);
            for (int i = 0; !Dispetcher.planComplete() && i < count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispetcher.addBuyer();
                allThreads.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }

        for (int time = 0; time < 120; time++) {    //в течение двух минут
            int count = Util.rnd(0, 2);     //в магазин приходят от 0 до 2 новых покупателей
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                allThreads.add(buyer);
                buyer.start();  //запуск потока
            }
            Util.sleep(1000);    //выполнение потока приостановлено на 1 секунду (1000 миллисекунд), метод от имени класса Util
        }

        for (Thread t : allThreads) {
            try {
                t.join();   //приостановка потока, пока другой не завершит свою работу
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
