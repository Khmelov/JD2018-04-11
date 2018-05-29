package by.it.rogov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

 class BuyerQueue {
    private BuyerQueue() {
    }

    private static Deque<Buyer> eqeue = new LinkedList<>();

    static synchronized void addEqeue(Buyer buyer) {
        eqeue.addLast(buyer);
    }

    static synchronized Buyer extractBuyerFromEqeue() {
        return eqeue.pollFirst();

    }
}
