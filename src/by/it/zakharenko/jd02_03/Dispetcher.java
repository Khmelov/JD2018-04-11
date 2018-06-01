package by.it.zakharenko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispetcher {

    private static final Object countMonitor = new Object();

    private static final Integer planCount = 100;          //всего 100 покупателей
    private static AtomicInteger countBuyerInShop = new AtomicInteger(0);     //кол-во покупателей в магазине
    private static AtomicInteger countBuyerComplete = new AtomicInteger(0);  //кол-во обслуженных покупателей

    static void addBuyer() {
        synchronized (countMonitor) {
            countBuyerInShop.incrementAndGet();
        }
    }

    static void completeBuyer() {
        synchronized (countMonitor) {
            countBuyerInShop.decrementAndGet();
            countBuyerComplete.incrementAndGet();
        }
    }

    static boolean openedMarket() {
        return (countBuyerComplete.get()< planCount);
    }

    static boolean planComplete() {
        return (countBuyerComplete.get() + countBuyerInShop.get()) >= planCount;
    }
}
