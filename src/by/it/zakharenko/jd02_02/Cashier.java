package by.it.zakharenko.jd02_02;

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
        while (Dispetcher.openedMarket()) {   //поиск покупателя в очереди, пока не выполнен план
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();  //нашли покупателя
            if (buyer != null) {
                System.out.println(this + " обслуживает " + buyer);
                Util.sleep(Util.rnd(2000, 5000));   //время обслуживания одного покупатея от 2 до 5 секунд
                System.out.println(this + " завершил обслуживание " + buyer);
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
