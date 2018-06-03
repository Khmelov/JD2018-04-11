package by.it.shekh.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {

    static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer) {
        // можно synchronized(BuyerQueue.class){
        deque.addLast(buyer);
        // }
    }

    static synchronized Buyer extractBuyerFromQueue() {
        // можно synchronized(BuyerQueue.class){
        return deque.pollFirst();
        // }
    }
}
