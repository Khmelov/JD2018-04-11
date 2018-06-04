package by.it.rogov.jd02_03;




import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

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
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 2; i++) {
            executorService.execute(new Cashiers(i));
        }
        executorService.shutdown();

        while (!Dispetcher.planMarket()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispetcher.planMarket()&&i < count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispetcher.addBuyer();
                buyer.start();
            }
            Util.sleep(1000);
        }

        while (!executorService.isTerminated())
            Util.sleep(20);
        System.out.println("Магазин закрыт");
    }
}
