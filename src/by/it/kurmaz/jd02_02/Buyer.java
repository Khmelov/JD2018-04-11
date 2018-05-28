package by.it.kurmaz.jd02_02;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBucket {

    private boolean old;
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
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enters market");
        System.out.println(old ? this + " is old" : this + " is young");
    }

    @Override
    public void chooseGoods() {
        Util.sleep(Util.getRandom(10000, 15000), old);
        System.out.println(this + " selected the goods");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " leaves market");
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
        Util.sleep(Util.getRandom(3000, 5000), old);
        System.out.println(this + " takes a bucket");
    }

    @Override
    public void putGoodsToBucket() {
        HashMap<String, Integer> bucket = Goods.takeGoods();
        for (Object o : bucket.entrySet()) {
            Util.sleep(Util.getRandom(3000, 5000), old);
            System.out.println(this + " put goods: " + o);
        }
    }
}
