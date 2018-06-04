package by.it.tarasiuk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    private static final Integer planCount = 100;
    private static AtomicInteger countBuyersInShop = new AtomicInteger(0);
    private static AtomicInteger countBuyersComplete = new AtomicInteger(0);

    static void addBuyer() {
        countBuyersInShop.incrementAndGet();
    }

    static void completeBuyers() {
        countBuyersInShop.decrementAndGet();
        countBuyersComplete.incrementAndGet();
    }

    static boolean openedMarket() {
        return (countBuyersComplete.get() < planCount);
    }

    static boolean planComplete() {
        return (countBuyersComplete.get() + countBuyersInShop.get()) >= planCount;
    }
}
