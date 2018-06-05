package by.it.kasiyanov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class BuyerQueue {

    private static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer){
        deque.addLast(buyer);
    }

    static synchronized Buyer extractBuyerFromQueue(){
        return deque.pollFirst();
    }

    static synchronized int getCount(){
        return deque.size();
    }
}
