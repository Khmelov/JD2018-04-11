package by.it.kasiyanov.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends Thread {

    private static final Object countMonitor = new Object();

    static final int plan = 100;
    private static AtomicInteger countBuyerInShop = new AtomicInteger(0);
    private static AtomicInteger countBuyerComplete = new AtomicInteger(0);
    private static volatile double sales = 0;


    static CopyOnWriteArrayList<Thread> cashiers = new CopyOnWriteArrayList<>();
    private static Deque<Integer> freeCashiersNumber = new LinkedList<>();

    ExecutorService executor = Executors.newFixedThreadPool(5);

    @Override
    public void run() {
        while (countBuyerComplete.get() < plan) {
            if (BuyerQueue.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Cashier cashier;
                executor.execute(cashier = new Cashier(getCashiersNumbers()));
                cashiers.add(cashier);
                addToThreadsQueue(cashier);
            }
            Util.sleep(1000);
        }
        executor.shutdown();
    }

    static void addBuyer(){
        countBuyerInShop.incrementAndGet();
    }

    static void completeBuyer(){
        countBuyerInShop.decrementAndGet();
        countBuyerComplete.incrementAndGet();
    }

    static void salesCount(double sum){
        synchronized (countMonitor){
            sales += sum;
        }
    }

    static double sales() {
        synchronized (countMonitor) {
            return sales;
        }
    }

    static synchronized int getCashiersNumbers(){
        if (freeCashiersNumber.size() > 0){
            return freeCashiersNumber.pollFirst();
        }
        else return (cashiers.size() + 1);
    }

    static synchronized void setCashiersNumbers(int cashierNumber){
        freeCashiersNumber.addLast(cashierNumber);
    }

    static synchronized void addToThreadsQueue(Thread cashier){
        Market.allThreads.add(cashier);
    }

    static boolean planComplete(){
        return (countBuyerComplete.get() + countBuyerInShop.get() >= plan);
    }
}
