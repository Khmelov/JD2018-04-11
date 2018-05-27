package by.it.mokhart.jd02_01;

public class Buyer extends Thread implements IBuyer {
    public Buyer(int customer) {
        super("Покупатель № " + customer);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println("В магазин вошёл " + this.getName());
    }

    @Override
    public void chooseGoods() {
        int timer = 500 + (int) Math.random() * 2001;
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            System.out.println("Работает некорректно");

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
}
