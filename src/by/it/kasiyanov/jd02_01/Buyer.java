package by.it.kasiyanov.jd02_01;


import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioner = false;

    public Buyer(int number){
        super("Покупатель № " + number);
        if (number % 4 > 0){
            this.pensioner = true;
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошёл в магазин");
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout, pensioner);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout, pensioner);
        System.out.println(this + " выбрал товар");
    }

    @Override
    public void putGoodsToBacket() {
        int numberOfGoods = Util.rnd(1, 4);
        Map<String, Integer> exactBuying = new HashMap<>();
        for (int i = 0; i < numberOfGoods; i++) {
            String nameItemOfGoods = "Item of goods №" + Util.rnd(1, 20);
            if (exactBuying.containsKey(nameItemOfGoods)){
                int quontity = exactBuying.get(nameItemOfGoods) + 1;
                exactBuying.put(nameItemOfGoods,quontity);
            }
            else exactBuying.put(nameItemOfGoods, 1);
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout, pensioner);
            System.out.println(this + " положил " + nameItemOfGoods + " в корзину");
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }
}
