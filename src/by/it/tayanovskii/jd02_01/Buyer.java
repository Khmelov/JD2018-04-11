package by.it.tayanovskii.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {


    private boolean pensioneer=false;

    public Buyer(int number) {

        super("Покупатель №" + number);
        if(number % 4 == 0) pensioneer=true;
    }



    @Override
    public void run() {
        enterToMarket();
        takeBacket();
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
        if(pensioneer) timeout = Util.rnd(750, 3000);
        Util.sleep(timeout);
        int countGoods = Util.rnd(1, 4);
        double totalCost=0;
        for (int i = 0; i < countGoods; i++) {
            putGoodsToBacket();
        }
        System.out.println(this + " выбрал товары");
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
        if(pensioneer) timeout = Util.rnd(150, 300);
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");

    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200);
        if(pensioneer) timeout = Util.rnd(150, 300);
        Util.sleep(timeout);
        String good=Goods.putRandomGoods();
        System.out.println(this + " выбрал " + good);


    }
}
