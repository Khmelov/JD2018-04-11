package by.it.shumilov.jd02_03;



import java.util.ArrayList;
import java.util.List;

public class Market {






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




        int time = 0;
        while (!Dispatcher.planComlete()) {
            time++;
            //System.out.println("-----------------------------second "+ time);
            int secunda = time%60;



            int count = Util.rnd(0,2);  //regular inThread buyers//////////////
            for (int i = 0; !Dispatcher.planComlete() && i <  count; i++) {


                if(number%4==0) {
                    if (open(secunda)){
//                        Buyer buyer1 = new Buyer(++number,true);
//                        allBuyers.add(buyer1);
                        Dispatcher.addBuyer();
                        new Buyer(++number,true).start();
                    }
                }
                else
                {
                    if (open(secunda)){
//                        Buyer buyer = new Buyer(++number);
//                        allBuyers.add(buyer);
                        Dispatcher.addBuyer();
                        new Buyer(++number).start();
                    }
                }


            }


            Util.sleep(1000);

        }




        try {
            thManager.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println(BuyerQueue.getSizeP());
        System.out.println("Магазин закрыт");
    }


    private static boolean open(int secunda){
        boolean res = false;



        if(secunda <30){
            if( Dispatcher.getcountBuyerInShop() >= (secunda+10))
                res = true;
        }
        else {
            if(Dispatcher.getcountBuyerInShop() <= (70 - secunda))
                res = true;
        }

        return res;
    }
}
