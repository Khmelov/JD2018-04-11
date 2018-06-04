package by.it.rogov.jd02_03;

 class Dispetcher {
    private static final Object synchronMonitor = new Object();

    private static final Integer amountBuyer = 100;
    private static volatile int amountBuyerInShop = 0;
    private static volatile int amountBuyerCompled = 0;

    static void addBuyer() {
        synchronized (synchronMonitor) {
            amountBuyerInShop++;
        }
    }

    static void completBuer() {
        synchronized (synchronMonitor) {
            amountBuyerInShop--;
            amountBuyerCompled++;
        }
    }

    static boolean openMarket() {
        return (amountBuyerCompled < amountBuyer);
    }

    static boolean planMarket() {
        return ((amountBuyerInShop + amountBuyerCompled) >= amountBuyer);
    }
}
