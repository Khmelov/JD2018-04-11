package by.it.dkruchek.jd02_02;

/**
 * Created by Dmitriy.Kruchek on 5/28/2018.
 */
public class Cashier implements Runnable{

    private int number;
    private String name;

    Cashier(int number){
        this.number = number;
        name = "Cashier # " + number;
    }

    //
    private void serveBuyer(Buyer buyer){

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(buyer);
        for (String good : buyer.basket) {
            System.out.println(this + " is serving " + buyer);
            System.out.println(good + ": " + Market.goods.get(good));
        }
        notify();
    }
    public void run(){
        System.out.println(name + " opened the counter");
        while (Dispatcher.openMarket()){
            Buyer buyer = BuyerQueue.getBuyerFromQueue();
            if (buyer != null){
                Util.sleep(Util.rnd(2000, 5000));
                serveBuyer(buyer);
                System.out.println(this + " finished serving " + buyer);
                Dispatcher.completeBuyer();
                synchronized (buyer){
                    buyer.notify();
                }
            }
            else Util.sleep(10);
        }

    }

    @Override
    public String toString() {
        return name;
    }


}
