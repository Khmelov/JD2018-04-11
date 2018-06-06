package by.it.lanevich.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket{

    private List<String> basket= new ArrayList<>();
    private boolean pensioner;

    private Map<String, Double> goods= new HashMap<>();

    private void goodsPut(){
        goods.put("Продукт1", 7.65);
        goods.put("Продукт2", 6.94);
        goods.put("Продукт3", 5.45);
        goods.put("Продукт4", 4.9);
        goods.put("Продукт5", 3.4);
        goods.put("Продукт6", 2.85);
        goods.put("Продукт7", 1.9);

    }


    Buyer(int number) {

        super("Покупатель №" + number);
        pensioner=(number%4==0);
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
        int timeout = Util.rnd(500, 2000, pensioner ? 1.5 : 1.0);
        Util.sleep(timeout);
        int count=Util.rnd(1,4);
        goodsPut();
        for (int i = 0; i < count; i++) {
           int index=Util.rnd(0,goods.size()-1);
            for (String good:goods.keySet()) {
                if(index==0) {
                    putGoodsToBacket(good);
                    break;
                }
                index--;
            }
        }
       // System.out.println(this + " выбрал товары");

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
        int timeout = Util.rnd(100, 200, pensioner ? 1.5 : 1.0);
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket(String good) {
        int timeout = Util.rnd(100, 200, pensioner ? 1.5 : 1.0);
        Util.sleep(timeout);
        basket.add(good);
        System.out.println(this+" положил в корзину "+good);
    }
}
