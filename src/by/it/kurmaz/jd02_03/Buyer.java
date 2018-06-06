package by.it.kurmaz.jd02_03;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBucket {

    private static Semaphore letsGotoGoods = new Semaphore(20);
    private static Semaphore letsTakeBucket = new Semaphore(50);
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
            Cashier cashier = Dispatch.wakeLastCashier();
            if (cashier.getState() == State.WAITING) {
                //System.out.println("Waking a cashier");
                synchronized (cashier) {
                    cashier.notify();
                }
            }
        }
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterToMarket() {
        if (letsTakeBucket.availablePermits() == 0) {
            Util.sleep(1000, false);
        }
        //System.out.println(this + " enters market");
        //System.out.println(old ? this + " is old" : this + " is young");
    }

    @Override
    public void chooseGoods() {
        try {
            letsGotoGoods.acquire();
            Util.sleep(Util.getRandom(5000, 7000), old);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            letsGotoGoods.release();
        }

        //System.out.println(this + " selected the goods");
    }

    @Override
    public void goToOut() {
        //System.out.println(this + " leaves market");
        Market.list.remove(this);

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBucket() {
        try {
            letsTakeBucket.acquire();
            Util.sleep(Util.getRandom(1000, 2000), old);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            letsTakeBucket.release();
        }

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
