package by.it.shumilov.jd02_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Market {

    //static LinkedList<Buyer> buersInShop = new LinkedList<>();

    static List<Buyer> allBuyers = new ArrayList<>();

    public static void main(String[] args) {
        int number = 0;


        System.out.println("Магазин открыт");
        for (int time = 0; time < 120; time++) {
            int count = Util.rnd(0,2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                allBuyers.add(buyer);
                buyer.start();
            }


            Util.sleep(1000);

        }

        for (Buyer allBuyer : allBuyers) {
            try {
                allBuyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        Buyer buyer = new Buyer(0);
//        buyer.start();
//
//        try {
//            buyer.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Магазин закрыт");
    }
}
