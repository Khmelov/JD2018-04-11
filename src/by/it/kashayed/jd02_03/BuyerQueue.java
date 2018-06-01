package by.it.kashayed.jd02_03;


import java.util.concurrent.LinkedBlockingDeque;

public class BuyerQueue {

    static LinkedBlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);

        static void addToQueue(Buyer buyer){
                try {
                    deque.putLast(buyer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
        static  Buyer extractBuyerFromQueue(){

              return  deque.pollFirst();

        }
}
