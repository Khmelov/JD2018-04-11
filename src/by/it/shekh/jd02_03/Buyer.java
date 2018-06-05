package by.it.shekh.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean isPensioner = false;
    private Map<String, Integer> goodsInBasket;

    private static Semaphore buyerSemaphore = new Semaphore(20);
    private static Semaphore basketSemaphore = new Semaphore(50);


    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    private double sum = 0;

    Buyer(int number) {
        super("Покупатель №" + number);
        if (number % 4 == 0)
            isPensioner = true;
    }

    private boolean isPensioner() {
        return isPensioner;
    }


    @Override
    public void run() {
        enterToMarket();
        try {
            basketSemaphore.acquire();//берем разрешение у семафора на взятие корзины
            takeBasket();
            try {
                buyerSemaphore.acquire();
                chooseGoods();
                goToQueue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                buyerSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            basketSemaphore.release();
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBasket() {
        int timeout;
        if (isPensioner())
            timeout = Util.rnd(200, 400);
        else
            timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        goodsInBasket = new HashMap<String, Integer>();
        System.out.println(this + " взял корзину");

    }


    @Override
    public void chooseGoods() {
        String goodName;
        int timeout;
        if (isPensioner())
            timeout = Util.rnd(1000, 4000);
        else
            timeout = Util.rnd(500, 2000);
        for (int i = 0; i < Util.rnd(1, 5); i++) {
            Util.sleep(timeout);
            goodName = Goods.getRndProduct();
            putGoodsToBasket(goodName);
            setSum(Goods.getGoodPrice(goodName) + getSum());
            System.out.println(goodName + " по цене " + Goods.getGoodPrice(goodName) + "$ в корзине " + this);
        }
        System.out.println(this + " выбрал товары");
    }

    @Override
    public void putGoodsToBasket(String pr) {
        int timeout;
        if (isPensioner())
            timeout = Util.rnd(200, 400);
        else
            timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        if (!goodsInBasket.containsKey(pr))
            goodsInBasket.put(pr, 1);
        else
            goodsInBasket.put(pr, goodsInBasket.get(pr + 1));
        System.out.println(this + " положил товары в корзину");
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
}
