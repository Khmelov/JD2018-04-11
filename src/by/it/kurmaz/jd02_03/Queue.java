package by.it.kurmaz.jd02_03;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class Queue {
    private Queue() {
    }

    private final static LinkedBlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);

    private final static LinkedBlockingDeque<Buyer> oldDeque = new LinkedBlockingDeque<>(30);

    static void addToQueue(Buyer buyer) {
        try {
            if (buyer.isOld())
                oldDeque.put(buyer);
            else
                deque.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static Buyer extractBuyerFromQueue() {
        try {
            return deque.poll(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    static Buyer extractBuyerFromOld() {
        try {
            return oldDeque.poll(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    static int getQueueSize () {
        return deque.size();
    }

    static int getOldQueueSize () {
        return oldDeque.size();
    }
}
