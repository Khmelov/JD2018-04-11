package by.it.shumilov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {

    private  BuyerQueue(){

    }

    private  static  int coutCas = 0;

    private  static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void addToQueue(Buyer buyer){ //синхронизация по классу or  synchronized(Buyer.class){}

        deque.addLast(buyer);

        Manager.setSize((int) Math.ceil(deque.size()/5.0));

        /*int five = (int) Math.ceil(deque.size()/5.0);
        if (five > coutCas){
            coutCas = five;


        }*/

    }

    static synchronized Buyer extractBuyerFromQueue(){ //синхронизация по классу or  synchronized(Buyer.class){}
        /*int five = (int) Math.ceil(deque.size()/5.0);
        if (five < coutCas){
            coutCas = five;
        }*/
        Buyer buyer = deque.pollFirst();
        Manager.setSize((int) Math.ceil(deque.size()/5.0));
        return buyer;///removeFirst();
    }


    static  synchronized int getSize(){
        return coutCas;
    }
}
