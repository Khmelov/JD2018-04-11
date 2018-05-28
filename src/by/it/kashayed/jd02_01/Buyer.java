package by.it.kashayed.jd02_01;

public class Buyer extends Thread implements  Runnable,IBuyer, IUsedBacket{

    int num;

    public Buyer(int number){
        this.num =number;
        this.setName("Покупатель №"+number+" ");
        start();
    }
    public  void run(){
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBAcket();
        goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println("Покупатель "+this+" вошел в магазин");
    }

    @Override
    public void takeBacket() {
    try{
        int pause = Rnd.fromTo(100,200);
        Thread.sleep(pause);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        System.out.println("Покупатель "+this+" взял корзину");

    }

    @Override
    public void chooseGoods() {
    try{
        int pause = Rnd.fromTo(500,2000);
        Thread.sleep(pause);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        System.out.println("Покупатель "+this+" выбирает товар");
    }
    @Override
    public void putGoodsToBAcket() {
        int goods =Goods.goods();
        try{
            int pause = Rnd.fromTo(100,200);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Покупатель "+this+" положил в корзину " + goods+" товар(а)");

    }

    @Override
    public void goOut() {
        System.out.println("Покупатель "+this+" вышел из магазина");

        }

    @Override
    public String toString() {
        return this.getName();
    }




}
