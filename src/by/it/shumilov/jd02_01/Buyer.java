package by.it.shumilov.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer,IUseBacket{

    public  Buyer(int number){
        super("" + number);
    }

    Map<String,Double> Goods = new HashMap<String,Double>(){{
        put("молоко",  1.2);
        put("чай", 2.6);
        put("хлеб",   1.1);
        put("пельмени",  3.0);
        put("батон", 1.5);
        put("конфеты",  34.8);
        put("гречка", 20.1);
        put("колбаса",33.3);
        put("творог",   1.5);
        put("сыр",  18.4);
        put("кровать", 156.1);
        put("акваланг",   345.9);
    }};

    @Override
    public void run() {
        enterToMarket();
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
        System.out.println(this + " выбрал товар");
    }


    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " положил выбранный товар в корзину");
    }
}
