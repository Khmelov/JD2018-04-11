package by.it.kasiyanov.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {
    public static List<Thread> allThreads = new ArrayList<>();
    public static Map<String, Double> buying = new HashMap<>();

    public static void main(String[] args) {
        int number = 0;
        Printer.printLine("Магазин открыт");

        for (int i = 1; i < 21; i++) {
            double priseOfGoods = (double) Math.round(Math.random() * 100);
            buying.put(("Товар №" + i), priseOfGoods);
        }

        while (!Dispatcher.planComplete()) {
            new Dispatcher().start();
            for (int time = 0; time < 120; time++) {  // Time - for changing in part C
                int count = Util.rnd(0, 2);
                for (int i = 0; !Dispatcher.planComplete() && i < count; i++) {
                    Buyer buyer = new Buyer(++number);
                    Dispatcher.addBuyer();
                    allThreads.add(buyer);
                    buyer.start();
                }
                Util.sleep(1000);
            }
        }

        for (Thread thread : allThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Printer.printLine("Магазин закрыт");
    }
}
