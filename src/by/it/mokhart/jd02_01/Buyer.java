package by.it.mokhart.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    int counter = 0;

    boolean pensioneer() {
        if (counter % 4 == 0) return true;
        else return false;
    }

    public Buyer(int customer) {
        super("Customer № " + customer);
    }

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
        System.out.println("В магазин вошёл " + this.getName());
    }

    @Override
    public void chooseGoods() {
        int timer = 500 + (int) Math.random() * 2000;
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        System.out.println("Выбрал товары " + this);
    }

    @Override
    public void goOut() {
        System.out.println("Из магазина вышел " + this);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        int timer = 100 + (int) Math.random() * 200;
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Взял корзину " + this);
    }

    @Override
    public void putGoodsToBacket() {
        int timer = 100 + (int) Math.random() * 200;
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Положил выбранный товар в корзину " + this);
    }
}
