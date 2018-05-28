package by.it.zaliashchonak.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Buyer(int number) {
        super("Покупатель №" + number);
    }


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        takeBacket();
        putGoodsToBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Util.rnd(5); i++) {
            Util.sleep(500, 2000);
            String goodName = Goods.rndGood();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this + " выбрал товар " + goodName + " цена: " + goodPrice + ".");
        }
        System.out.println(this + " завершил выбор.");

    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        Util.sleep(100, 200);
        System.out.println(this + " взял корзину.");

    }

    @Override
    public void putGoodsToBacket() {
        Util.sleep(100, 200);
        System.out.println(this + " положил товары в корзину.");
    }
}
