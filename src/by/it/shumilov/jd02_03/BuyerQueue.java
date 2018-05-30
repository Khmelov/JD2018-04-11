package by.it.shumilov.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BuyerQueue {

    private  BuyerQueue(){

    }

    private volatile  static double sumMarket = 0;

    //private  static Deque<Buyer> deque = new LinkedList<>();

    private  static LinkedBlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30); ///////////////////////////////

    private  static LinkedBlockingDeque<Buyer> dequePensioners = new LinkedBlockingDeque<>();

    //private static

    static void addToQueue(Buyer buyer) {
        //System.out.println("add");
        if (buyer.getPensioner()){
            //System.out.println("pensioneraddddddddddddddddddddddddddddddd");

            while (deque.size()>0){
                if(deque.getFirst().getPensioner()) {
                    try {
                        dequePensioners.putLast(deque.pollFirst());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else break;
                }
            try {
                deque.putFirst(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <  dequePensioners.size(); i++) {
                try {
                    deque.putFirst(dequePensioners.pollLast());//////////////////////////////////////////////put
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            try {
                deque.putLast(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Manager.setSize((int) Math.ceil(deque.size()/5.0));

        /*int five = (int) Math.ceil(deque.size()/5.0);
        if (five > coutCas){
            coutCas = five;


        }*/

    }

    static Buyer extractBuyerFromQueue(){
        /*int five = (int) Math.ceil(deque.size()/5.0);
        if (five < coutCas){
            coutCas = five;
        }*/
        Buyer buyer = deque.pollFirst();
        Manager.setSize((int) Math.ceil(deque.size()/5.0));///////////////////////////
        //System.out.println("del");
        return buyer;///removeFirst();

    }

    public static void addSum(double sum){
        //System.out.println("get");
        sumMarket += sum;
    }

    public static double getSumMarket(){
        //System.out.println("get");
        return  sumMarket;
    }

    static synchronized int getSize(){
        //System.out.println("get");
        return deque.size();
    }
}
