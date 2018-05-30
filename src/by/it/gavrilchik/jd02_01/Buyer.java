package by.it.gavrilchik.jd02_01;

public class Buyer extends Thread implements IBuyer {

    public Buyer(int number) {
        super("Покупатель №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();

    }

    @Override
    public void enterToMarket() {

        System.out.println(this + " Вошел в магазин");

    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout);

        System.out.println(this + " Выбрал товары");

    }

    @Override
    public void goToOut() {
        System.out.println(this + " Вышел из магазина");

    }

    @Override
    public String toString() {
        return getName();
    }
}
