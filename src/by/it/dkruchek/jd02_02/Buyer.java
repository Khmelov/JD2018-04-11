package by.it.dkruchek.jd02_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy.Kruchek on 5/25/2018.
 */
class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean isPensioneer;
    List<String> basket;

    Buyer(int number){
        super("Buyer #" + number);
        isPensioneer = Util.rnd(1,4) == 4;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered the market");
        if (isPensioneer) System.out.println("Hey I'm old, let me in first");
    }

    @Override
    public void chooseGoods() {
        Util.buyerOperationWait(500,2000, isPensioneer);
        int goodsNumber = Util.rnd(1,4);
        List<String> goodsList = new ArrayList<>(Market.goods.keySet());

        for (int i = 0; i < goodsNumber; i++) {
            String good = goodsList.get(Util.rnd(0, goodsList.size() - 1));
            putGoodsToBasket(good);
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " went out of the market-->");
    }

    @Override
    public void takeBasket() {
        Util.buyerOperationWait(100,200, isPensioneer);
        basket = new ArrayList<>();
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGoodsToBasket(String good) {
        Util.buyerOperationWait(100,200, isPensioneer);
        basket.add(good);
        System.out.println(this + " put " + good + " into the basket");
    }

    @Override
    public void goToQueue(){
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
    public void run(){
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public String toString() {
        return getName();
    }
}
