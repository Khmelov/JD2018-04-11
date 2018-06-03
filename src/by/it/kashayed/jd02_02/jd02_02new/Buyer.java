package by.it.kashayed.jd02_02.jd02_02new;

class Buyer extends Thread implements IBuyer,IUsedBacket {


    public Buyer (int number){
        super("Покупатель № "+number);
    }

    @Override
    public void run() {
        enterToMarket();
        tackeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+ " вошел в магазин");
    }
    @Override
    public void tackeBacket() {
        Rnd.sleep(Rnd.rnd(100,200));
        System.out.println(this+ " взял корзину");
    }

    @Override
    public void chooseGoods() {
        Rnd.sleep(Rnd.rnd(500,2000));
        System.out.println(this+ " выбирает товар");
    }

    @Override
    public void putGoodsToBacket() {
        int goods = Rnd.rnd(1,4);
        int sleep = Rnd.rnd(100,200);
        Rnd.sleep(goods*sleep);                         //при условии что все товары выбирает одинаково по времени
        System.out.println(this+ " полоил в корзину "+goods+" товар(a)"+"\n"+  Goods.food(goods));

    }
    @Override
    public void goToQueue() {
        BuyerQueue.addToQueue(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void goOut() {
        System.out.println(this+ " вышел из магазина");

    }

    @Override
    public String toString() {
        return getName();
    }



}
