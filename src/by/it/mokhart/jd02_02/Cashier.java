package by.it.mokhart.jd02_02;

public class Cashier implements Runnable {

    private int number;
    private String name;

    Cashier(int number) {
        this.number = number;
        name = "Кассир № " + number;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу");
        while (Dispetcher.openedMarket()) {
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();
            if (buyer != null) {
                System.out.println(this + " обслуживает " + buyer);
                Util.sleep(Util.rnd(2000, 5000));
                double cheque = buyer.totalCheque();
                System.out.println(this + " завершил обслуживание " + buyer + ", сумма чека составляет " + cheque);
                Dispetcher.completeBuyer();
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(10);
        }
        System.out.println(name + " закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
