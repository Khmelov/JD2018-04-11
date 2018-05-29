package by.it.shumilov.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket{

    public  Buyer(int number){
        super("Покупатель " + number);
    }

    private boolean pensioneer = false;

    public  Buyer(int number, boolean pensioneer){



        super("Покупатель " + number);
        pensioneer = true;
    }



    private Map<String,Double> backet = new HashMap<>();


    @Override
    public void run() {
        enterToMarket();
        takeBacket();

        for (int i = 0; i < Util.rnd(1,4) ; i++) {
            int prod = Util.rnd(1, Util.Goods.size());

            Map.Entry<String, Double> product = Util.Goods.entrySet().stream().skip(prod - 1).findFirst().get();

            backet.put(product.getKey(),product.getValue());

            chooseGoods(product.getKey());
            putGoodsToBacket(product.getKey());
        }



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
    public void goOut() {
        System.out.println("-------------------------------");
        System.out.println("-" + this + " купил следующее:" );
        double sum = 0;
        for (Map.Entry<String, Double> entry : backet.entrySet()) {
            sum +=entry.getValue();
            System.out.printf("-%-10s : %4.2f\n",entry.getKey(), entry.getValue());
        }
        System.out.printf("-------Итого: %4.2f\n",sum);
        System.out.println("-------------------------------");
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
    public void putGoodsToBacket(String product) {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout,pensioneer);
        System.out.println(this + " положил " + product + " в корзину");
    }
}
