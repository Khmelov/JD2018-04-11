package by.it.kurmaz.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatch {

    private static final int plan = 100;
    private static final int buyersPerCashier = 5;
    static AtomicInteger buyerCounter = new AtomicInteger(0);
    static AtomicInteger income = new AtomicInteger(0);

    static final ConcurrentLinkedQueue cashiersWorking = new ConcurrentLinkedQueue();
    static int[] cashierNumbers = new int[5];

    static void completeBuyer() {
        buyerCounter.incrementAndGet();
    }

    static boolean enoughCashiers() {
        if ((Queue.getOldQueueSize() == 0) && (Queue.getQueueSize() == 0))
            return true;
        else if (cashiersWorking.size() == 0)
            return false;
        else if (cashiersWorking.size() == 5)
            return true;
        return (double)((Queue.getQueueSize() + Queue.getOldQueueSize()) / cashiersWorking.size()) <= buyersPerCashier;
    }

    static boolean planComplete() {
        return (Market.list.size() + buyerCounter.get()) >= plan;
    }

    static boolean cashierWorks(){
        return (buyerCounter.get()<plan);
    }

    static Cashier wakeLastCashier() {
        return (Cashier) Dispatch.cashiersWorking.peek();
    }

}
