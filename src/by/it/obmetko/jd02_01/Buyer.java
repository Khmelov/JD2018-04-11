package by.it.obmetko.jd02_01;




public class Buyer extends Thread implements IBuyer,IUseBasket {

    private final static Integer monitor1 = 0;

    private String name;

    int nm = 0;

    boolean pensioneer() {
        if (nm % 4 == 0) return true;
        else return false;
    }

    public Buyer(int number) {
        nm = number;
        if (!pensioneer()) {
            name = "Покупатель № " + number;
        } else {
            name = "Покупатель № " + number + " пенсионер";
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        QueueBuyer.addBuyer(this);
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        synchronized (monitor1) {
            Market.countBuyersInShop--;
        }

    }

    @Override
    public void takeBacket() {
        if (!pensioneer()) {
            Util.sleep(Util.random(100, 200));
        } else {
            Util.sleep(Util.random(150, 300));
        }
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        int p=Util.random(1,4);
        for (int i = 1; i <= p; i++) {

            if (!pensioneer()) {
                Util.sleep(Util.random(100, 200));
            } else {
                Util.sleep(Util.random(150, 300));
            }
            int prod= Util.random(0, Goods.productList.size()-1);
            String goodName = Goods.rndGoodName().get(prod);
            Double price = Goods.productList.get(prod).getValue();
            System.out.println(this + "положил " + goodName + " в корзину стоимостью: " +  price + ".");
        }



    }

    @Override
    public void chooseGoods() {
        int count = Util.random(1, 4);
        for (int i = 0; i < count; i++) {
        if (!pensioneer()) {
            Util.sleep(Util.random(500, 2000));
        } else {
            Util.sleep(Util.random(750, 3000));
        }
            System.out.println(this + "выбрал товар");
            QueueBuyer.addBuyer(this);


        }
    }
        @Override
        public String toString() {
            return name + " ";
        }
    }


