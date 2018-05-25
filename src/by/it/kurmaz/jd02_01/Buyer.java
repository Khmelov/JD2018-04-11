package by.it.kurmaz.jd02_01;

public class Buyer extends Thread implements IBuyer {

    Buyer(String name) {
        super("Buyer " + name);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println("Buyer " + this + " enters market");
        TaskA.list.add(this);
    }

    @Override
    public void chooseGoods() {
        Util.sleep(Util.getRandom(500, 2000));
        System.out.println("Buyer " + this + " got the goods");
    }

    @Override
    public void goToOut() {
        System.out.println("Buyer " + this + " leaves market");
        TaskA.list.remove(this);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
