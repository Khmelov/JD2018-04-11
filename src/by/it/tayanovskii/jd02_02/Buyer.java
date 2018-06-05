package by.it.tayanovskii.jd02_02;


import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {


    private boolean pensioneer = false;
    private HashMap<String, Double> backet;

    public Buyer(int number) {

        super("Покупатель №" + number);
        if (number % 4 == 0) pensioneer = true;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {

        int timeout = Util.rnd(500, 2000);
        if (pensioneer) timeout = Util.rnd(750, 3000);
        Util.sleep(timeout);
        int countGoods = Util.rnd(1, 4);
        for (int i = 0; i < countGoods; i++) {
            putGoodsToBacket();
        }
//        Double totalCostGoods = 0.0;
//        for (Double element : backet.values()) {
//                totalCostGoods += element;
//        }
        System.out.println(this + " выбрал товары на сумму: " + getTotalCost(this));
    }

    @Override
    public void goToQueue() {
        BuyerQueue.addToQueue(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200);
        if (pensioneer) timeout = Util.rnd(150, 300);
        backet = new HashMap<>();
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");

    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200);
        if (pensioneer) timeout = Util.rnd(150, 300);
        Util.sleep(timeout);
        //String good=Goods.putRandomGoods();
        Map.Entry<String, Double> randomGoods = Goods.getRandomGoods();
        backet.put(randomGoods.getKey(), randomGoods.getValue());
        System.out.println(this + " выбрал " + randomGoods);

    }
    static synchronized Double getTotalCost (Buyer buyer)
    {
        Double totalCostGoods = 0.0;
        for (Double element : buyer.backet.values()) {
            totalCostGoods += element;
        }
        return totalCostGoods;
    }
}
