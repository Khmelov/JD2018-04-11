package by.it.shumilov.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {


    private HashMap<String,Double> backet = new HashMap<>();
    private boolean pensioneer = false;


    public  Buyer(int number){

        super(String.format("Покупатель %3d" , number));

    }


    public  Buyer(int number, boolean pensioneer){

        super(String.format("Покупатель%s %3d" , (pensioneer)?(" (пенсионер)"):(""), number));
        this.pensioneer = pensioneer;

    }





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

        System.out.println(this + " вошел в магазин" );
    }

    @Override
    public void chooseGoods(String product) {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout,pensioneer);
        System.out.println(this + " выбрал товар " + product);
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " встал в очередь++++++++++++++++++++++++++++++++++++++++");
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
    public HashMap<String,Double> getBacket(){
        return backet;
    }

    public boolean getPensioner(){
        return pensioneer;
    }
}
