package by.it.zakharenko.jd02_01;

import java.util.*;

public class Market {

    static List<Buyer> allBuyers = new ArrayList<>();

    public static void main(String[] args) {
        int number = 0;
        System.out.println("Магазин открыт");

        for (int time = 0; time < 120; time++) {    //в течение двух минут
            int count = Util.rnd(0, 2);     //в магазин приходят от 0 до 2 новых покупателей
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                allBuyers.add(buyer);
                buyer.start();  //запуск потока
            }
            Util.sleep(1000);    //выполнение потока приостановлено на 1 секунду (1000 миллисекунд), метод от имени класса Util
        }

        for (Buyer buyer : allBuyers) {
            try {
                buyer.join();   //приостановка потока, пока другой не завершит свою работу
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
