package by.it.dkruchek.jd02_02;

/**
 * Created by Dmitriy.Kruchek on 5/28/2018.
 */
public class Dispatcher {

    private static final Object countMonitor = new Object();

    private static final int planCount = 100;
    private static volatile int countBuyerInShop = 0; // сколько внутри магазина
    private static volatile int countBuyerComplete = 0; // сколько покупателей обслужено


    static void addBuyer() {
        synchronized (countMonitor) {
            //countMonitor.
            countBuyerInShop++;
        }
    }

    static void completeBuyer() {
        synchronized (countMonitor) {
            //countMonitor.
            countBuyerInShop--;
            countBuyerComplete++;
        }
    }

    static boolean planComplete(){
        return (countBuyerComplete + countBuyerInShop) >= planCount;
    }

    static boolean openMarket(){
        return countBuyerComplete < planCount;
    }

}

