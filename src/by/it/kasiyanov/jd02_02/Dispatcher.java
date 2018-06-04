package by.it.kasiyanov.jd02_02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Dispatcher extends Thread {

    private static final Object countMonitor = new Object();

    static final int plan = 100;
    private static volatile int countBuyerInShop = 0;
    private static volatile int countBuyerComplete = 0;
    private static volatile double sales = 0;

    static List<Thread> cashiers = new ArrayList<>();
    private static Deque<Integer> freeCashiersNumber = new LinkedList<>();

    @Override
    public void run() {
        while (countBuyerComplete < plan) {
            if (BuyerQueue.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Thread cashier = new Thread(new Cashier(getCashiersNumbers()));
                cashiers.add(cashier);
                addToThreadsQueue(cashier);
                cashier.start();
            }
            Util.sleep(1000);
        }
    }

    static void addBuyer(){
        synchronized (countMonitor){
            countBuyerInShop++;
        }
    }

    static void completeBuyer(){
        synchronized (countMonitor){
            countBuyerInShop--;
            countBuyerComplete++;
        }
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
        return (countBuyerComplete + countBuyerInShop >= plan);
    }
}
