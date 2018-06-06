package by.it.kasiyanov.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner = false;

    ConcurrentMap<String, Integer> exactBuying = new ConcurrentHashMap<>();

    public Buyer(int number){
        super("Покупатель № " + number);
        if (number % 4 > 0){
            this.pensioner = true;
        }
    }

    public boolean isPensioner() {
        return pensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        Printer.printLine(this + " вошёл в магазин");
    }

    @Override
    public void takeBasket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout, pensioner);
        Printer.printLine(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout, pensioner);
        Printer.printLine(this + " выбрал товар");
    }

    @Override
    public void putGoodsToBasket() {
        int numberOfGoods = Util.rnd(1, 4);
        for (int i = 0; i < numberOfGoods; i++) {
            String nameItemOfGoods = "Товар №" + Util.rnd(1, 20);
            if (exactBuying.containsKey(nameItemOfGoods)){
                int quantity = exactBuying.get(nameItemOfGoods) + 1;
                exactBuying.put(nameItemOfGoods,quantity);
            }
            else exactBuying.put(nameItemOfGoods, 1);
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout, pensioner);
            Printer.printLine(this + " положил " + nameItemOfGoods + " в корзину");
        }
    }

    @Override
    public void goToQueue() {
        Printer.printLine(this + " стал в очередь");
        BuyerQueue.addToQueue(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goToOut() {
        Printer.printLine(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }
}
