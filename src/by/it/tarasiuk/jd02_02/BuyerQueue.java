package by.it.tarasiuk.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class BuyerQueue {
    private BuyerQueue() {
    }

    private static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer) {
        deque.addLast(buyer);
    }

    static synchronized Buyer extractBuyerFromQueue() { return deque.pollFirst(); }

    static int getSize() { return deque.size(); }
}
