package by.it.shumilov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {

    private  BuyerQueue(){

    }

    private  static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer){ //синхронизация по классу or  synchronized(Buyer.class){}

        deque.addLast(buyer);
    }

    static synchronized Buyer extractBuyerFromQueue(){ //синхронизация по классу or  synchronized(Buyer.class){}

        return deque.pollFirst();///removeFirst();
    }
}
