package by.it.kashayed.jd02_02.jd02_02new;

public class Dispatcher {

    static private final Object objMonitor=new Object();

    private static final int planCount=100;
    private static volatile int countBuyerInSHop=0;
    private static volatile int countBuyerComplete=0;


    static void addBuyer(){
        synchronized (objMonitor){
            countBuyerInSHop++;
        }
    }
    static void completeBuyer(){
        synchronized (objMonitor){
            countBuyerInSHop--;
            countBuyerComplete++;
        }
    }

    static boolean shopOpened(){
        return countBuyerComplete<planCount;
    }

    static boolean planComplete(){
       return (countBuyerInSHop+countBuyerComplete)>=planCount;
    }
}
