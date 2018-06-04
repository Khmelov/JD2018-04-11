package by.it.kashayed.jd02_03;

public class Cashier implements Runnable {

    private int number;
    private String name;

    Cashier (int number){
        this.number = number;
        name = "Кассир № "+ number;
    }

    @Override
    public void run() {

        System.out.println(this+" открыл кассу");
        while(Dispatcher.shopOpened()){
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();
            if(buyer!=null){

                System.out.println(this+" обслуживает клиента "+ buyer);
                Rnd.sleep(Rnd.rnd(2000,5000));
                System.out.println(buyer+" сумма чека = "+Goods.sum);
                System.out.println(this+" обслужил клиента "+ buyer);
                Dispatcher.completeBuyer();
                synchronized (buyer){
                    buyer.notify();
                }

            }
            else Rnd.sleep(10);
        }
        System.out.println(name+" закрыл кассу");

    }


    @Override
    public String toString() {
        return name;
    }
}
