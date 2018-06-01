package by.it.kurmaz.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Dispatch {
    static final Integer monitor = 0;
    private static final int plan = 100;
    private static final int buyersPerCashier = 5;
    static volatile int buyerCounter;
    static volatile int income;

    static Deque<Cashier> cashiersWorking = new LinkedList<>();
    static int[] cashierNumbers = new int[5];

    static void completeBuyer() {
        buyerCounter++;
    }

    static boolean enoughCashiers() {
        if ((Queue.getOldQueueSize() == 0) && (Queue.getQueueSize() == 0))
            return true;
        else if (cashiersWorking.size() == 0)
            return false;
        else if (cashiersWorking.size() == 5)
            return true;
        return ((Queue.getQueueSize() + Queue.getOldQueueSize()) / cashiersWorking.size()) <= buyersPerCashier;
    }

    static boolean planComplete() {
        return (Market.list.size() + buyerCounter) >= plan;
    }

    static boolean cashierWorks(){
        return (buyerCounter<plan);
    }

}
