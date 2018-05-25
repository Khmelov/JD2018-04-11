package by.it.kurmaz.jd02_01;

import java.util.LinkedList;

public class TaskA {

    static LinkedList<Buyer> list = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Shop is opened");
        int counter = 1;
        for (int i = 0; i < 120; i++) {
            int count = Util.getRandom(0, 2);
            for (int j = 0; j < count; j++) {
                Buyer buyer = new Buyer("Buyer # " + counter);
                buyer.start();
                counter++;
                Util.sleep(1000);
            }
        }

        while (list.size() > 0)
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("Shop closed");
    }
}
