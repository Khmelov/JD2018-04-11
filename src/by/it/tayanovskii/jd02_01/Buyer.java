package by.it.tayanovskii.jd02_01;

import java.util.ArrayList;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    Goods goods;
    private ArrayList<String> backet = new ArrayList<>();

    public Buyer(int number, Goods anotherGoods) {
        super("Покупатель №" + number);
        this.goods = anotherGoods;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout);
        int countGoods = Util.rnd(1, 4);
        for (int i = 0; i < countGoods; i++) {
            putGoodsToBacket();
        }
        System.out.println(this + " выбрал товары");
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
        Util.sleep(timeout);
        this.backet = new ArrayList<>();
        System.out.println(this + " взял корзину");

    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        String good=goods.putRandomGoods();
        backet.add(good);
        System.out.println(this + " выбрал " + good);


    }
}
