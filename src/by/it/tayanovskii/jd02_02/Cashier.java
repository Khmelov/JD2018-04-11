package by.it.tayanovskii.jd02_02;

class Cashier implements Runnable {

    private int number;

    private String name;

    Cashier(int number) {
        this.number = number;
        name = "Кассир № " + number;
    }

    @Override
    public void run() {
        System.out.println(name + " открыл кассу");
        while (Dispatcher.openedMarket()) {
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();
            if (buyer != null) {
                System.out.println(this + " обслуживает " + buyer);
                Util.sleep(Util.rnd(2000, 5000));
                System.out.println(this + " завершил обслуживание " + buyer);
                Dispatcher.completeBuyer();
                synchronized (buyer) {
                    buyer.notify();
                }
            }
            else
                Util.sleep(10);

            if (Dispatcher.countBuyerInShop<number*5)
            {
                System.out.println(name + " приостановил работу");
                Util.sleep(2000);
            }

        }
        System.out.println(name + " закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
