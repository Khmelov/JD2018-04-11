package by.it.mokhart.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioneer = false;

    public Buyer(int number) {
        super("Покупатель №" + number);
        if (number % 4 > 0) {
            this.pensioneer = true;
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBasket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout, pensioneer);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout, pensioneer);
        System.out.println(this + " выбрал товары");
    }

    @Override
    public void putGoodsToBasket() {
        Map<String, Integer> buy = new HashMap<>();
        int numberOfGoods = Util.rnd(1, 4);
        for (int i = 0; i < numberOfGoods; i++) {
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout, pensioneer);
            String product;
            int goodsHelper = Util.rnd(1, 4);
            if (goodsHelper == 1) {
                product = "Сыр";
            } else if (goodsHelper == 2) {
                product = "Хлеб";
            } else if (goodsHelper == 3) {
                product = "Вода";
            } else {
                product = "Соль";
            }
            String nameOfGoods = product;
            Integer priceofGoods = (int) (Math.random() * 100);
            if (buy.containsKey(nameOfGoods) || buy.containsValue(priceofGoods)) {
                buy.put(nameOfGoods + 1, priceofGoods + 1);
            } else buy.put(nameOfGoods, priceofGoods);
            System.out.println(this + " положил товар " + nameOfGoods + " с ценой " + priceofGoods + " в корзину");
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
