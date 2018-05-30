package by.it.shumilov.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    public  Buyer(int number){
        super("Покупатель " + number);
    }

    private boolean pensioneer = false;

    public  Buyer(int number, boolean pensioneer){



        super("Покупатель " + number);
        pensioneer = true;
    }



    private static HashMap<String,Double> backet = new HashMap<>();


    @Override
    public void run() {
        enterToMarket();
        takeBacket();

        for (int i = 0; i < Util.rnd(1,4) ; i++) {
            int prod = Util.rnd(1, Util.Goods.size());

            Map.Entry<String, Double> product = Util.Goods.entrySet().stream().skip(prod - 1).findFirst().get();

            backet.put(product.getKey(),product.getValue());

            chooseGoods(product.getKey());
            putGoodsToBacket(product);
        }


        goToQueue();
        goOut();
    }


    @Override
    public void enterToMarket() {

        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods(String product) {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout,pensioneer);
        System.out.println(this + " выбрал товар " + product);
    }

    @Override
    public void goToQueue() {
        BuyerQueue.addToQueue(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        ////////////////////////////////////////////////////////////////////////////////////////////
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
        Util.sleep(timeout,pensioneer);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket(Map.Entry<String,Double> product) {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout,pensioneer);
        System.out.println(this + " положил " + product.getKey() + " стоимостью " + product.getValue() + " в корзину");
    }
    public static HashMap<String,Double> getBacket(){
        return backet;
    }
}
