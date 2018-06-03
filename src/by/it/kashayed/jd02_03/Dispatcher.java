package by.it.kashayed.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {


    private static final int planCount=100;
    private static AtomicInteger countBuyerInSHop=new AtomicInteger(0);
    private static  AtomicInteger countBuyerComplete=new AtomicInteger(0);


    static void addBuyer(){

            countBuyerInSHop.getAndIncrement();

    }
    static void completeBuyer(){

            countBuyerInSHop.getAndDecrement();
            countBuyerComplete.getAndIncrement();

    }

    static boolean shopOpened(){
        return countBuyerComplete.get()<planCount;
    }

    static boolean planComplete(){
       return (countBuyerInSHop.get()+countBuyerComplete.get())>=planCount;
    }
}
