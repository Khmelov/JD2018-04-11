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

    private  static Deque<Buyer> dequePensioners = new LinkedList<>();

    //private static

    static void addToQueue(Buyer buyer) {
        //System.out.println("add");
        if (buyer.getPensioner()){
            //System.out.println("pensioneraddddddddddddddddddddddddddddddd");

            while (deque.size()>0){
                if(deque.getFirst().getPensioner()) {

                    dequePensioners.addLast(deque.pollFirst());

                }
                else break;
            }


            try {
                deque.putFirst(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            int  sizePensioners = dequePensioners.size();
            for (int i = 0; i <  sizePensioners; i++) {
                try {
                    Buyer buyer1 = dequePensioners.pollLast();
                    //System.out.println(buyer1);
                    //if(!buyer1.equals(null))
                        deque.putFirst(buyer1);//////////////////////////////////////////////put
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

        //Manager.setSize((int) Math.ceil(deque.size()/5.0));

        /*int five = (int) Math.ceil(deque.size()/5.0);
        if (five > coutCas){
            coutCas = five;


        }*/

    }

    static Buyer extractBuyerFromQueue(){

        return deque.pollFirst();

    }

    public static void addSum(double sum){
        //System.out.println("getS");
        sumMarket += sum;
    }

    public static double getSumMarket(){
        //System.out.println("getSM");
        return  sumMarket;
    }

    static synchronized int getSize(){
        //System.out.println("getSi");
        return deque.size();
    }
    static synchronized int getSizeP(){
        //System.out.println("getSi");
        return dequePensioners.size();
    }
}