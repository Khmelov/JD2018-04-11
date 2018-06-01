package by.it.zakharenko.jd02_01;

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
        System.out.println(this + " вошел в магазин");  //мгновенно
    }

    @Override
    public void takeBasket() {
        int timeout = Util.rnd(100, 200);  //от 0,1 до 0,2 секунд
        Util.sleep(timeout, pensioneer);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);    //выбор товара от 0,5 до 2 секунд
        Util.sleep(timeout, pensioneer);
        System.out.println(this + " выбрал товары");
    }

    @Override
    public void putGoodsToBasket() {
        Map<String, Integer> buy = new HashMap<>();
        int numberOfGoods = Util.rnd(1, 4);  //набор от 1 до 4 товаров
        for (int i = 0; i < numberOfGoods; i++) {
            int timeout = Util.rnd(100, 200);  //от 0,1 до 0,2 секунд
            Util.sleep(timeout, pensioneer);
            String nameOfGoods = "номер " + Util.rnd(1, 20);
            Integer priceofGoods = (int) (Math.random() * 100);
            if (buy.containsKey(nameOfGoods) || buy.containsValue(priceofGoods)) {
                buy.put(nameOfGoods +1, priceofGoods+1);
            } else buy.put(nameOfGoods, priceofGoods);
            System.out.println(this + " положил товар " + nameOfGoods + " с ценой " + priceofGoods + " в корзину");
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");  //мгновенно
    }

    @Override
    public String toString() {
        return getName();
    }
}
