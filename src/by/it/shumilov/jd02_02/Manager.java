package by.it.shumilov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class Manager implements  Runnable {
    private static int count = 0;

    private enum Action {DELETE,ADD,WAIT}

    private static Action action = Action.ADD;

    private  static Deque<Cashier> deque = new LinkedList<>();

    static synchronized void addToQueue(Cashier cashier){ //синхронизация по классу or  synchronized(Buyer.class){}

        deque.addLast(cashier);
    }

    static synchronized Cashier extractCashierFromQueue(){ //синхронизация по классу or  synchronized(Buyer.class){}

        return  deque.pollLast();  ///removeFirst();
    }



    @Override
    public void run() {
        System.out.println("Манеджер стартанул");
        while (Dispatcher.openedMarket()){

            //System.out.println("----------------------------------------------------------Act "+ action);

            if(action.equals(Action.ADD)){
                //System.out.println("----------------------------------------------------------Add ");
                //Thread thCashier = new Thread(new Cashier(++count);)
                Cashier cashier = new Cashier(++count);
                //cashier.run();
                cashier.start();
                addToQueue(cashier);
                action = Action.WAIT;

            }
            if(action.equals(Action.DELETE) && count>=2){
                extractCashierFromQueue().closeCassa();
                count--;
                action = Action.WAIT;
            }

            if(action == Action.WAIT){
                Util.sleep(10);
            }
            else action = Action.WAIT;


        }
        System.out.println("Манеджер закончил");
    }
    public synchronized static void setSize(int size){
        if(size > count){
            action = Action.ADD;

        }
        else if(size < count){
            action = Action.DELETE;
        }


    }
}