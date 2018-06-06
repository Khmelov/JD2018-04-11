package by.it.mokhart.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    public static void main(String[] args) {
        int number = 0;
        System.out.println("Магазин открыт");

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            executor.execute(new Cashier(i));
        }
        executor.shutdown();

        while (!Dispetcher.planComplete()) {
            int count = Util.rnd(0, 2);
            for (int i = 0; !Dispetcher.planComplete() && i < count; i++) {
                Dispetcher.addBuyer();
                new Buyer(++number).start();
            }

            Util.sleep(1000);
        }

        while (!executor.isTerminated())
            Util.sleep(50);
        System.out.println("Магазин закрыт");

    }
}
