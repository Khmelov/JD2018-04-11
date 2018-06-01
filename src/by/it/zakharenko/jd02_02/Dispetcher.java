package by.it.zakharenko.jd02_02;

public class Dispetcher {

    private static final Object countMonitor = new Object();

    private static final Integer planCount = 100;          //всего 100 покупателей
    private static volatile int countBuyerInShop = 0;     //кол-во покупателей в магазине
    private static volatile int countBuyerComplete = 0;  //кол-во обслуженных покупателей

    static void addBuyer() {
        synchronized (countMonitor) {
            countBuyerInShop++;
        }
    }

    static void completeBuyer() {
        synchronized (countMonitor) {
            countBuyerInShop--;
            countBuyerComplete++;
        }
    }

    static boolean openedMarket() {
        return (countBuyerComplete < planCount);
    }

    static boolean planComplete() {
        return (countBuyerComplete + countBuyerInShop) >= planCount;
    }
}
