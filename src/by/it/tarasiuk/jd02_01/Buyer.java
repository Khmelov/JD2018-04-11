package by.it.tarasiuk.jd02_01;

public class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Покупатель №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
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
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }
}