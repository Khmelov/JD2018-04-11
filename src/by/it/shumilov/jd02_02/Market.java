package by.it.shumilov.jd02_02;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class Market {

    //static LinkedList<Buyer> buersInShop = new LinkedList<>();

    private  static final Object allMonitor = new Object();

    static List<Thread> allBuyers = new ArrayList<>();



    public static void main(String[] args) {
        int number = 0;
        boolean open = true;

//        Lock lock = new reentrantLock();
//
//        lock.lock();
//        try {
//            // update object state
//        }
//        finally {
//            lock.unlock();
//        }




        System.out.println("Магазин открыт");

        /*
        for (int i = 1; i < 3; i++) {
            Thread thCashier = new Thread(new Cashier(i));
            thCashier.start();
            allBuyers.add(thCashier);
        }*/

        Thread thManager = new Thread(new Manager());
        thManager.start();
        allBuyers.add(thManager);


        int time = 0;
        while (!Dispatcher.planComlete()) {
            time++;
            System.out.println("-----------------------------second "+ time);
            int secunda = time%60;



            int count = Util.rnd(0,2);
            for (int i = 0; !Dispatcher.planComlete() && i <  count; i++) {


                if(number%4==0) {
                    if (open(secunda)){
                        Buyer buyer1 = new Buyer(++number,true);
                        allBuyers.add(buyer1);
                        Dispatcher.addBuyer();
                        buyer1.start();
                    }
                }
                else
                {
                    if (open(secunda)){
                        Buyer buyer = new Buyer(++number);
                        allBuyers.add(buyer);
                        Dispatcher.addBuyer();
                        buyer.start();
                    }
                }


            }


            Util.sleep(1000);

        }

        for (Thread allBuyer : allBuyers) {
            try {
                allBuyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        Buyer buyer = new Buyer(0);
//        buyer.start();
//
//        try {
//            buyer.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Магазин закрыт");
    }
    private static boolean open(int secunda){
        boolean res = false;


        synchronized(allBuyers){
            if(secunda <30){
                if(allBuyers.size() >= (secunda+10))
                    res = true;
            }
            else {
                if(allBuyers.size() <= (70 - secunda))
                    res = true;
            }
        }

        return res;
    }
}
