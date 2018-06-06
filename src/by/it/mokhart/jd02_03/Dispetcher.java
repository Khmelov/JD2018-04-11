package by.it.mokhart.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispetcher {

    private static final Object countMonitor = new Object();

    private static final Integer planCount = 100;
    private static AtomicInteger countBuyerInShop = new AtomicInteger(0);
    private static AtomicInteger countBuyerComplete = new AtomicInteger(0);

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
        return (countBuyerComplete.get() < planCount);
    }

    static boolean planComplete() {
        return (countBuyerComplete.get() + countBuyerInShop.get()) >= planCount;
    }
}
