package by.it.kurmaz.jd02_02;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBucket {

    private boolean old;
    private HashMap<String, Integer> bucket;

    Buyer(String name, boolean old) {
        super(name);
        this.old = old;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        putGoodsToBucket();
        goToQueue();
        goToOut();
    }

    private void goToQueue() {
        Queue.addToQueue(this);
        //System.out.println(this + " goes to queue");
        if (Dispatch.cashiersWorking.size() == 1) {
            Cashier cashier = Queue.wakeLastCashier();
            if (cashier.getState() == State.WAITING) {
                //System.out.println("Waking a cashier");
                synchronized (cashier) {
                    cashier.notify();
                }
            }
        }
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterToMarket() {
        //System.out.println(this + " enters market");
        //System.out.println(old ? this + " is old" : this + " is young");
    }

    @Override
    public void chooseGoods() {
        Util.sleep(Util.getRandom(7000, 12000), old);
        //System.out.println(this + " selected the goods");
    }

    @Override
    public void goToOut() {
        //System.out.println(this + " leaves market");
        synchronized (Market.monitor) {
            Market.list.remove(this);
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBucket() {
        Util.sleep(Util.getRandom(1000, 2000), old);
        //System.out.println(this + " takes a bucket");
    }

    @Override
    public void putGoodsToBucket() {
        bucket = Goods.takeGoods();
    }

    HashMap<String, Integer> serveBucket() {
        return bucket;
    }

    boolean isOld() {
        return old;
    }
}
