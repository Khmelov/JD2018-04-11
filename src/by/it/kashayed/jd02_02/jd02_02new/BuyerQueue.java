package by.it.kashayed.jd02_02.jd02_02new;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {

        private static Deque<Buyer> deque = new LinkedList<>();

        static void addToQueue(Buyer buyer){
            synchronized (deque) {
                deque.addLast(buyer);
            }
        }
        static  Buyer extractBuyerFromQueue(){
            synchronized (deque) {
              return  deque.pollFirst();

            }
        }
}
