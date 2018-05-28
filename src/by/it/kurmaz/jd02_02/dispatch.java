package by.it.kurmaz.jd02_02;

public class dispatch {

    private static final int plan = 100;
    private static volatile int buyerCounter;

    static void completeBuyer() {
        buyerCounter++;
    }

    static boolean planComplete() {
        return (Market.list.size() + buyerCounter) >= plan;
    }

}
