package by.it.kurmaz.jd02_01;

import java.util.LinkedList;

public class TaskA {

    static LinkedList<Buyer> list = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Shop is opened");
        Goods.createBucket();
        System.out.println("Bucket is created");
        int counter = 1;
        boolean isOld;
        int second;
        boolean condition;
        for (int i = 0; i < 120; i++) {
            second = i % 60;
            if ((second % 10) == 0)
                System.out.println("Second: " + second + " buyers: " + list.size());
            if (second <= 30)
                condition = (list.size() < (second + 10));
            else
                condition = (list.size()< (40 + (30 - second)));
            if (condition) {
                int count = Util.getRandom(1, 2);
                for (int j = 0; j < count; j++) {
                    isOld = ((Util.getRandom(1, 4)) % 4 == 0);
                    Buyer buyer = new Buyer("Buyer # " + counter, isOld);
                    buyer.start();
                    counter++;
                }
                Util.sleep(1000, false);
            }
            else
                Util.sleep(1000, false);
            }

        while (list.size() != 0)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        /*if (list.size() != 0) {
            for (Buyer buyer : list) {
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
        System.out.println("Shop closed");
    }
}
