package by.it.shumilov.jd02_03;

public class Dispatcher {

    private  static final Object countMonitor = new Object();

    private static final int planCount = 100; //
    private static volatile int countBuyerInShop = 0; //до кассы
    private static volatile int countBuyerComplete = 0; //после кассы

    static void addBuyer(){
        synchronized (countMonitor){

            countBuyerInShop++;
        }
    }

    static void comleteBuyer(){
        synchronized (countMonitor){
            //System.out.println("comleteBuyer");
            countBuyerInShop--;
            countBuyerComplete++;
        }
    }

    static  boolean openedMarket(){
        //System.out.println("openedMarket");
        return countBuyerComplete < planCount;
    }

    static boolean planComlete(){
        //System.out.println("planComlete");
        return (countBuyerComplete + countBuyerInShop) >= planCount;
    }

}
