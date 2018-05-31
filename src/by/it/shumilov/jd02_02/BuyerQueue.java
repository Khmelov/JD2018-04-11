package by.it.shumilov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyerQueue {

    private  BuyerQueue(){

    }

    private volatile  static  double sumMarket = 0;

    private  static Deque<Buyer> deque = new LinkedList<>();
    private  static Deque<Buyer> dequePensioners = new LinkedList<>();

    //private static

    static synchronized void addToQueue(Buyer buyer) { //синхронизация по классу or  synchronized(Buyer.class){}
        if (buyer.getPensioner()){
            //System.out.println("pensioneraddddddddddddddddddddddddddddddd");

            while (deque.size()>0){
                if(deque.getFirst().getPensioner())
                    dequePensioners.addLast(deque.pollFirst());
                else break;
            }
            deque.addFirst(buyer);
            for (int i = 0; i <  dequePensioners.size(); i++) {
                deque.addFirst(dequePensioners.pollLast());
            }
        }
        else
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
        Manager.setSize((int) Math.ceil(deque.size()/5.0));///////////////////////////
        return buyer;///removeFirst();
    }

    public static void addSum(double sum){
        sumMarket += sum;
    }

    public static double getSumMarket(){
        return  sumMarket;
    }

    static synchronized int getSize(){
        return deque.size();
    }
}
