package by.it.rogov.jd02_02;

public class Cashiers implements Runnable {

    private int number;
    private String name;

    Cashiers(int number) {
        this.number = number;
        name = "Кассир №" + number;

    }

    @Override
    public void run() {
        System.out.println(name + " открыл кассу");
        while (Dispetcher.openMarket()) {
            Buyer buyer = BuyerQueue.extractBuyerFromEqeue();
            if (buyer != null) {
                System.out.println(this + " обслуживает " + buyer);
                Util.sleep(Util.rnd(2000, 5000));
                System.out.println(this + " завершил обслживание " + buyer);
                Dispetcher.completBuer();
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(10);

        }

        System.out.println(name + "закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
