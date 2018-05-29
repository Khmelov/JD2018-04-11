package by.it.shumilov.jd02_02;

public class Cashier extends Thread{

    private  int number;

    private  String name;

    private  boolean open = true;

    public Cashier(int number){
        this.number = number;
        name = "Кассир № " + number;
    }

    @Override
    public void run() {
        System.out.println("Открыл кассу " + number);

        while (open && Dispatcher.openedMarket()){/////////////////////////////////////
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();
            if(buyer !=null){
                System.out.println(this + " обслуживает " + buyer);
                Util.sleep(Util.rnd(2000,5000));
                System.out.println(this + " закончил обслуживание " + buyer);
                Dispatcher.comleteBuyer();

                synchronized (buyer){
                    buyer.notify();
                }
            }
            else
                Util.sleep(10);

        }

        System.out.println(name + " закрыл кассу");
    }
    public void closeCassa(){
        this.open = false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
