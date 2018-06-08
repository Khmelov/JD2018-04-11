package by.it.kasiyanov.jd02_03;

import java.util.Map;
import java.util.Set;

public class Cashier extends Thread {

    private String name;
    private int number;

    Cashier(int number) {
        this.number = number;
        name = "Кассир № " + number;
    }

    @Override
    public void run() {
        Printer.printLine(this + " кассир открыл кассу");
        while (BuyerQueue.getCount() > 0) {

            Buyer buyer = BuyerQueue.extractBuyerFromQueue();
            if (buyer != null) {
                Printer.printLine(this + " обслуживает " + buyer);
                Util.sleep(Util.rnd(2000, 5000), buyer.isPensioner());
                // add pensioner
                Printer.printLine(this + " завершил обслуживание покупателя " + buyer);

                synchronized (Printer.printMonitor) {
                    Set<Map.Entry<String, Integer>> set = buyer.exactBuying.entrySet();
                    double sum = 0.0;
                    Printer.lineBreak();
                    for (Map.Entry<String, Integer> me : set) {
                        String line = me.getKey() + " " + me.getValue() + "x" + Market.buying.get(me.getKey());
                        Printer.cashierPrint(this.number, line);
                        sum += Market.buying.get(me.getKey()) * me.getValue();
                    }
                    Dispatcher.salesCount(sum);
                    //System.out.println("Сумма по чеку у " + buyer + " = " + sum);
                    Printer.cashierLastLine(BuyerQueue.getCount(), Dispatcher.sales());
                    Printer.lineBreak();
                }

                Dispatcher.completeBuyer();
                synchronized (buyer) {
                    buyer.notify();
                }
            }

            if (BuyerQueue.getCount() < (Dispatcher.cashiers.size() * 5 - 4)) {
                Printer.printLine(this + " кассир закрыл кассу");
                Dispatcher.setCashiersNumbers(this.number);
                Dispatcher.cashiers.remove(this);
                Printer.printLine("осталось кассиров " + Dispatcher.cashiers.size());
                break;
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
