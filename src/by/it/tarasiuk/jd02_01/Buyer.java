package by.it.tarasiuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket = new Basket();
    private boolean pensioner = false;

    Buyer(int number) {
        super("Покупатель №" + number);
        if ((number % 2 == 0) && (Util.rnd(0, 1) == 0)) {
            pensioner = true;
        }
    }


    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        if (!pensioner) System.out.println(this + " вошел в магазин");
        else System.out.println(this + " - пенсионер вошел в магазин");

    }

    @Override
    public void takeBasket() {
        int timeout = Util.rnd(100, 200);
        if (pensioner) timeout=Util.rnd(150,300);
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int numberOfProducts = Util.rnd(1, 4);
        List<String> goodsList = new ArrayList<>(Goods.goodsInMarket.keySet());
        for (int i = 0; i < numberOfProducts; i++) {
            int timeout = Util.rnd(500, 2000);
            if (pensioner) timeout=Util.rnd(750,3000);
            Util.sleep(timeout);
            String product = goodsList.get(Util.rnd(0, goodsList.size() - 1));
            System.out.println(this + " выбрал товар: " + product
                    + ", стоимостью: " + Goods.goodsInMarket.get(product));
            putGoodsToBasket(product);
        }
    }

    @Override
    public void putGoodsToBasket(String product) {
        int timeout = Util.rnd(100, 200);
        if (pensioner) timeout=Util.rnd(150,300);
        Util.sleep(timeout);
        basket.addProduct(product);
        System.out.println(this + " положил " + product + " в корзину");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }
}