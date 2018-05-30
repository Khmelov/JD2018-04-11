package by.it.zakharenko.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {

    private BuyerQueue() {
    }

    private static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer) {
        deque.addLast(buyer);
    }

    static synchronized Buyer extractBuyerFromQueue() {
        return deque.pollFirst();
    }

    static int getSizeQueue(){
        return deque.size();
    }

}
