package by.it.kashayed.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
        static int countBuyer =0;

    public static void main(String[] args) throws InterruptedException {
        Queue<Buyer> deque = new ArrayDeque<>();
        int second= 0;
        while (second<240){
            second++;
            Thread.sleep(1000);
            second++;
            int count = Rnd.fromTo(0,2);
            for (int i = 0; i < count; i++) {
                countBuyer++;
               //if (countBuyer<11){
                    Buyer buyer = new Buyer(countBuyer);
                    deque.add(buyer);
                //}
            }
        }
    }
}
