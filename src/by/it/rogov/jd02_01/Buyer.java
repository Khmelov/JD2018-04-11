package by.it.rogov.jd02_01;


import java.util.*;


public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Buyer(int number) {
        super("Покупатель №" + number);
    }

    private Map<String, Double> Backet = new HashMap<>();
    private List<String> goodsMarket = new ArrayList<String>(Market.goods.keySet());
    double sum = 0.0;

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
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
        Util.sleep(Util.rnd(100, 200));
        System.out.println(this + "Взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        int amountGoods = Util.rnd(1, 4);

        for (int i = 0; i < amountGoods; i++) {
            Util.sleep(Util.rnd(100, 200));
            int numberGoods = Util.rnd(1, Market.goods.size()-1);
            String s = goodsMarket.get(numberGoods);
            sum += Market.goods.get(s);
            Backet.put(s, Market.goods.get(s));

        }

        System.out.print(this + "положил в карзину" + Backet.keySet());
        System.out.printf(" на сумму: %.2f",sum);
        System.out.println();
    }
}
