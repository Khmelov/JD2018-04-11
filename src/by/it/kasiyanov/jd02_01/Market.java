package by.it.kasiyanov.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {
    static List<Buyer> allBuyers = new ArrayList<>();
    public static Map<String, Integer> buying = new HashMap<>();

    public static void main(String[] args) {
        int number = 0;
        System.out.println("Магазин открыт");

        for (int i = 0; i < 20; i++) {
            int priseOfGoods = (int) (Math.random() * 100);
            buying.put(("Item of goods №" + i), priseOfGoods);
        }

        for (int time = 0; time < 120; time++) {
            if (time <= 10 || (time > 60 && time <= 70)) {
                int count = Util.rnd(1, 1);
                if (number > 10) {
                } else {
                    for (int i = 0; i < count; i++) {
                        Buyer buyer = new Buyer(++number);
                        allBuyers.add(buyer);
                        buyer.start();
                    }
                    Util.sleep(1000);
                }
            } else if ((time > 10 && time <= 30) || (time > 70 && time <= 90)) {
                if ((time > 20 || time > 80) && number < (45 + 45 * time / 60)) {
                    int count = Util.rnd(2, 2);
                    for (int i = 0; i < count; i++) {
                        Buyer buyer = new Buyer(++number);
                        allBuyers.add(buyer);
                        buyer.start();
                        Util.sleep(1000);
                    }
                } else {
                    int count = Util.rnd(1, 2);
                    if (number >= (45 + 45 * time / 60)) {
                    } else {
                        for (int i = 0; i < count; i++) {
                            Buyer buyer = new Buyer(++number);
                            allBuyers.add(buyer);
                            buyer.start();
                        }
                        Util.sleep(1000);
                    }
                }
            } else if ((time > 30 && time <= 60) || time > 90) {
                if (number <= (70 - (time - 60 * (time / 60)))) {
                    int count = Util.rnd(0, 2);
                    for (int i = 0; i < count; i++) {
                        Buyer buyer = new Buyer(++number);
                        allBuyers.add(buyer);
                        buyer.start();
                    }
                    Util.sleep(1000);
                }
            }
        }
        for (Buyer buyer : allBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
