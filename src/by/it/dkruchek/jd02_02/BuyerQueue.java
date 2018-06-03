package by.it.dkruchek.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Dmitriy.Kruchek on 5/28/2018.
 */
public class BuyerQueue {

    private BuyerQueue(){

    }

    private static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer){
        deque.addLast(buyer);
    }

    static synchronized Buyer getBuyerFromQueue(){
        return deque.pollFirst();
    }

}
