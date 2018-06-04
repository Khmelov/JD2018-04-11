package by.it.rogov.jd02_03;



import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class BuyerQueue {
    private BuyerQueue() {
    }

    private static LinkedBlockingDeque<Buyer> eqeue = new LinkedBlockingDeque<>(30);

    static int sizeBuyerInEque() {

        return eqeue.size();
    }

    static  void addEqeue(Buyer buyer) {
        try {
            eqeue.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static  Buyer extractBuyerFromEqeue() {
        try {
            return eqeue.poll(20,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }
}
