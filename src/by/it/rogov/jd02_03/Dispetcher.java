package by.it.rogov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispetcher {


    private static final Integer amountBuyer = 100;
    private static AtomicInteger amountBuyerInShop = new AtomicInteger(0);
    private static AtomicInteger amountBuyerCompled = new AtomicInteger(0);

    static void addBuyer() {

            amountBuyerInShop.incrementAndGet();

    }

    static void completBuer() {

            amountBuyerInShop.decrementAndGet();
            amountBuyerCompled.incrementAndGet();

    }

    static boolean openMarket() {
        return (amountBuyerCompled.get() < amountBuyer);
    }

    static boolean planMarket() {
        return ((amountBuyerInShop.get() + amountBuyerCompled.get()) >= amountBuyer);
    }
}
