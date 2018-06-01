package by.it.gavrilchik.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class BuyerQueue {

    private BuyerQueue() {
    }

    private static Deque<Buyer> deque = new LinkedList<>();


    static synchronized void addToQueue(Buyer buyer) {
        // synchronized (BuyerQueue.class) {
        deque.addLast(buyer);
        //}
    }

    static synchronized Buyer extractBuyerFromQueue() {
        // synchronized (BuyerQueue.class) {
        return deque.pollFirst();
        //}
    }

}
