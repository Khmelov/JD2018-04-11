package by.it.kurmaz.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {
    private Queue() {
    }

    private static Deque<Buyer> deque = new LinkedList<>();

    private static Deque<Buyer> oldDeque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer) {
        if (buyer.isOld())
            oldDeque.addLast(buyer);
        else
            deque.addLast(buyer);
    }

    static synchronized Buyer extractBuyerFromQueue() {
        return deque.pollFirst();
    }

    static synchronized Buyer extractBuyerFromOld() {
        return oldDeque.pollFirst();
    }

    static synchronized Cashier wakeLastCashier() {
        return Dispatch.cashiersWorking.peekFirst();
    }

    static synchronized int getQueueSize () {
        return deque.size();
    }

    static synchronized int getOldQueueSize () {
        return oldDeque.size();
    }
}
