package by.it.tarasiuk.jd02_02;

class Dispatcher {
    private static final Object countMonitor = new Object();
    private static final Integer planCount = 100;
    private static volatile int countBuyersInShop = 0;
    private static volatile int countBuyersComplete = 0;

    static void addBuyer() {
        synchronized (countMonitor) {
            countBuyersInShop++;
        }
    }

    static void completeBuyers() {
        synchronized (countMonitor) {
            countBuyersInShop--;
            countBuyersComplete++;
        }
    }

    static boolean openedMarket() {
        return (countBuyersComplete < planCount);
    }

    static boolean planComplete() {
        return (countBuyersComplete + countBuyersInShop) >= planCount;
    }
}
