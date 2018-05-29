package by.it.rogov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {
    private BuyerQueue() {
    }

    private static Deque<Buyer>  deque = new LinkedList<>();

    static synchronized void addDeque(Buyer buyer){
        deque.addLast(buyer);
    }
    static synchronized void extractBuyerFromDeque(){
        deque.pollFirst();
    }
}
