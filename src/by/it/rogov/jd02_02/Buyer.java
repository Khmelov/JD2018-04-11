package by.it.rogov.jd02_02;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 */


public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Buyer(int number) {
        super("Покупатель №" + number);
    }



    private Map<String, Double> Backet = new HashMap<>(); // карзина покупателя с ценами
    private List<String> goodsMarket = new ArrayList<>(Market.goods.keySet());  //выбранные  товары
    double sum = 0.0;

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToDeque();
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
    public void goToDeque() {
        BuyerQueue.addEqeue(this);      // add Buyer in qeue and wait when Cashier wake up his
        synchronized (this){
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
        Util.sleep(Util.rnd(100, 200));
        System.out.println(this + "Взял корзину");
    }

    @Override
    public synchronized  void putGoodsToBacket() {
        int amountGoods = Util.rnd(1, 4);

        for (int i = 0; i < amountGoods; i++) {
            Util.sleep(Util.rnd(100, 200));
            int numberGoods = Util.rnd(1, Market.goods.size()-1);
            String s = goodsMarket.get(numberGoods);
            sum += Market.goods.get(s);
            Backet.put(s, Market.goods.get(s));

        }
            System.out.print(this + "положил в карзину" + Backet.keySet());
//        System.out.printf(" на сумму: %.2f",sum);
            System.out.println();
    }
}
