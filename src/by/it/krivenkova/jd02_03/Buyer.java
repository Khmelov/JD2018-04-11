package by.it.krivenkova.jd02_03;

public class Buyer extends Thread implements Runnable,IBuyer, IUseBasket, Comparable<Buyer> {

    private String name;
private double speed;
    public Buyer(int number)//, boolean pensioner)
    {
        super( "Покупатель №" + number);
     /*   if(pensioner)
        {
            this.name = "Покупатель - песионер №" + number;
            this.speed = 1.15;
        }
        else {*/
       //     this.name = "Покупатель №" + number;
        //    this.speed = 1;
       // }
    }
    String getNameBuyer(){
        return  this.name;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
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
    public void goToQueue() {
        System.out.println(this + "встал в очередь");
        BuyerQueue.addToQueue(this);

        synchronized (this) {
            try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

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
    public void takeBasket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");

    }

    @Override
    public void putGoodsToBasket() {
        int i_randProduct = Util.rnd(1, 4);
        for (int i = 0; i <= i_randProduct; i++) {
            int timeout = Util.rnd(100,200);
            Util.sleep(timeout);
            int i_choiceProduct = Util.rnd(0, Goods.productList.size()-1);
            String nameProduct = Goods.productList.get(i_choiceProduct).getKey();
            Double priceProduct = Goods.productList.get(i_choiceProduct).getValue();

            System.out.println(this + " Положил товар: " + nameProduct + " [цена: " + priceProduct + "]  в корзину");

        }
       

    }

    @Override
    public int compareTo(Buyer o) {
        return 0;
    }
}
