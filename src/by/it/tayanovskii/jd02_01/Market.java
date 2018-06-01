package by.it.tayanovskii.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Buyer> allBuyers = new ArrayList<>();
    static int countBuyersInShop = 0;


    public static void main(String[] args) {
        int number = 0;
        Goods goods = new Goods();
        System.out.println("Магазин открыт");
        for (int time = 0; time < 120; time++) {
            int minute = time % 60;
            int count = Util.rnd(0, 2);
            if (minute <= 30 && countBuyersInShop >= (minute + 10)) {
                for (int i = 0; i < count; i++) {
                    Buyer buyer = new Buyer(++number);
                    allBuyers.add(buyer);
                    countBuyersInShop++;
                    buyer.start();
                }
            } else if (minute > 30 && countBuyersInShop <= 40 + (30 - minute)) {
                for (int i = 0; i < count; i++) {
                    Buyer buyer = new Buyer(++number);
                    allBuyers.add(buyer);
                    countBuyersInShop++;
                    buyer.start();
                }
            } else {
                Util.sleep(1);

            }

        }
        Util.sleep(1000);

        for (Buyer buyer : allBuyers)
        {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
