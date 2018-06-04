package by.it.kashayed.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner {

    static List<Buyer> allBuyer = new ArrayList<Buyer>() ;


    public static void main(String[] args) {


        int number=1;
        System.out.println("Магазин открыт");
        ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.execute(new Cashier(1));

//        Thread cashier = new Thread(new Cashier(1));
//        Thread cashier2 = new Thread(new Cashier(2));
//        cashier.start();
        while(!Dispatcher.planComplete()) {
            int count = Rnd.rnd(0, 2);
            for (int i = 0; !Dispatcher.planComplete()&& i < count; i++) {
                Buyer buyer=new Buyer(number++);
                Dispatcher.addBuyer();
                allBuyer.add(buyer);
                buyer.start();
              //  executor.execute(new Run(buyer));
            }
            Rnd.sleep(1000);
        }
        if(BuyerQueue.deque.size()>5){
            executor.execute(new Cashier(2));
//            cashier2.start();
        }

        executor.shutdown();
        for (Buyer buyer : allBuyer) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Rnd.sleep(100);
        System.out.println("Магазин закрыт");
    }

}
