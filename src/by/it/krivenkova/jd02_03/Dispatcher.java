package by.it.krivenkova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private static final Object countMonitor = new Object();

    private static final Integer planCount = 100;
    private static AtomicInteger/*volatile int*/ countBuyerInShop = new AtomicInteger(0);
    private static AtomicInteger/*volatile int*/ countBuyerComplete = new AtomicInteger(0);

    static void addBuyer() {
      /*  synchronized (countMonitor) {
            countBuyerInShop++;
        }*/
      countBuyerInShop.incrementAndGet();
    }

    static void completeBuyer() {
       /* synchronized (countMonitor) {
            countBuyerInShop--;
            countBuyerComplete++;
        }*/
       countBuyerInShop.decrementAndGet();
       countBuyerComplete.incrementAndGet();
    }

    static boolean openedMarket(){
        return (countBuyerComplete.get()<planCount);//countBuyerComplete<planCount);
    }

    static boolean planComplete() {
        return (countBuyerComplete.get()+countBuyerInShop.get()) >= planCount;//countBuyerComplete + countBuyerInShop) >= planCount;
    }


}
