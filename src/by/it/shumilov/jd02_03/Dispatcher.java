package by.it.shumilov.jd02_03;



import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    private static final int planCount = 100; //
    private static AtomicInteger countBuyerInShop = new AtomicInteger(0); //до кассы
    private static AtomicInteger countBuyerComplete = new AtomicInteger(0); //после кассы
    private static AtomicInteger countCashier = new AtomicInteger(0);

    static void  addCashier(){
        countCashier.incrementAndGet();
    }

    static  void  delCashier(){
        countCashier.decrementAndGet();
    }

    static int getCountCashier(){
        return  countCashier.get();
    }

    static void addBuyer(){

        countBuyerInShop.incrementAndGet();

    }

    static void comleteBuyer(){

        //System.out.println("comleteBuyer");
        countBuyerInShop.decrementAndGet();
        countBuyerComplete.incrementAndGet();

    }

    static  boolean openedMarket(){
        //System.out.println("openedMarket");
        return countBuyerComplete.get() < planCount;
    }

    static boolean planComlete(){
        //System.out.println("planComlete");
        return (countBuyerComplete.get() + countBuyerInShop.get()) >= planCount;
    }

    static Integer getcountBuyerInShop(){
        return  countBuyerInShop.get();
    }

}
