package by.it.krivenkova.jd02_03;


import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class BuyerQueue {

    private BuyerQueue() {
    }

    private static LinkedBlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);
    //Deque<Buyer> deque = new LinkedList<>();


    static /*synchronized*/ void addToQueue(Buyer buyer) {
        // synchronized (BuyerQueue.class) {
      //  deque.addLast(buyer);
        //}
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static /*synchronized*/ Buyer extractBuyerFromQueue() {
        // synchronized (BuyerQueue.class) {
        //return deque.pollFirst();
        //}
        try {
            return deque.poll(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
