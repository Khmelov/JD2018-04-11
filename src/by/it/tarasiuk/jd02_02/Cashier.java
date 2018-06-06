package by.it.tarasiuk.jd02_02;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
                double totalCost = 0;
                for (int i = 0; i < buyer.giveProducts().size(); i++) {
                    totalCost += Goods.goodsInMarket.get(buyer.giveProducts().get(i));
                }
                BigDecimal bd =new BigDecimal(totalCost);
                bd=bd.setScale(2,RoundingMode.DOWN);
                System.out.println(this +
                        ": \n\"Общая стоимость покупок для " + buyer +
                        " составила: " + bd + "\".\n" +
                        this + " завершил обслуживание " + buyer);
                Dispatcher.completeBuyers();
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Util.sleep(10);
        }
        System.out.println(name + " закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
