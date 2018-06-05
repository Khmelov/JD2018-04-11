package by.it.shekh.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Buyer> allBuyers = new ArrayList<>();


    public static void main(String[] args) {
        int number = 0;
        int buyerInsideShop = 0;
        System.out.println("Магазин открыт");
        Goods.addGoodsToShop();
        for (int time = 0; time < 120; time++) {
            if ((time == 0 || time == 60) && buyerInsideShop <= 10) {
                int count = Util.rnd(6, 10);
                for (int i = 0; i < count; i++) {
                    buyerInsideShop++;
                    Buyer buyer = new Buyer(++number);
                    allBuyers.add(buyer);
                    buyer.start();
                }
            }
            if ((time > 0 && time < 30 && buyerInsideShop <= time + 10)
                    || (time > 60 && time < 90 && buyerInsideShop <= time + 10)) {
                int count = Util.rnd(0, 2);
                for (int i = 0; i < count; i++) {
                    buyerInsideShop++;
                    Buyer buyer = new Buyer(++number);
                    allBuyers.add(buyer);
                    buyer.start();
                }
            }
            if ((time >= 30 && time < 60 && buyerInsideShop <= 40 + (30 - time))
                    || (time >= 90 && time < 120 && buyerInsideShop <= 40 + (30 - time))) {
                int count = Util.rnd(0, 2);
                for (int i = 0; i < count; i++) {
                    buyerInsideShop++;
                    Buyer buyer = new Buyer(++number);
                    allBuyers.add(buyer);
                    buyer.start();
                }
            }

            Util.sleep(1000);
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
