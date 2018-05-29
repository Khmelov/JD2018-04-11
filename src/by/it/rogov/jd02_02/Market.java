package by.it.rogov.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {

    static List<Thread> allThread = new ArrayList<>();

    static Map<String, Double> goods = new HashMap<>();

    public static void main(String[] args) {
        goods.put("Хлеб", 0.7);
        goods.put("Сметана", 1.2);
        goods.put("Молоко", 0.3);
        goods.put("Сыр", 2.4);
        goods.put("Яйца", 1.2);
        goods.put("Спички", 0.1);
        goods.put("Сахар", 0.9);
        goods.put("Соль", 0.3);
        goods.put("Чай", 2.1);
        goods.put("Кофе", 4.0);

        int number = 0;
        System.out.println("Магазин открыт");
        for (int i = 0; i < 2; i++) {
            Thread thCashier = new Thread(new Cashiers(i));
            thCashier.start();
            allThread.add(thCashier);
        }

        while (!Dispetcher.planMarket()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispetcher.planMarket()&&i < count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispetcher.addBuyer();
                allThread.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Thread buyer : allThread) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
