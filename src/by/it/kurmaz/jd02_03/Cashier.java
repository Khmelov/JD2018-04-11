package by.it.kurmaz.jd02_03;

import java.util.HashMap;

public class Cashier extends Thread {

    private String name;

    Cashier(int number) {
        this.name = "Cashier # " + number;
    }

    public String toString() {
        return name;
    }

    @Override
    public void run() {
        String[] sp = name.split("#");
        int cashierNumber = Integer.parseInt(sp[1].trim());
        Dispatch.cashierNumbers[cashierNumber] = 1;
        synchronized (Printer.monitor){
            Printer.printLine(cashierNumber, "Cashier Opened");
        }
        while (Dispatch.cashierWorks()) {
            Buyer buyer;
            if (Queue.getOldQueueSize() != 0)
                buyer = Queue.extractBuyerFromOld();
            else
                buyer = Queue.extractBuyerFromQueue();
            if (buyer != null) {
                synchronized (Printer.monitor) {
                    Printer.printLine(cashierNumber, "Serving " + buyer);
                    HashMap<String, Integer> bucket = buyer.serveBucket();
                    int sum = 0;
                    for (String item : bucket.keySet()) {
                        Printer.printLine(cashierNumber, "served: " + item);
                        //Util.sleep(Util.getRandom(1000, 3000), buyer.isOld());
                        sum += bucket.get(item);
                    }
                    Dispatch.income.set(Dispatch.income.get()+sum);
                    Printer.printLine(cashierNumber, "finished " + buyer);
                    Printer.printLine(cashierNumber, "Check: " + sum);
                    Printer.printLine(cashierNumber, "Customers left:");
                    Printer.printLine(5, ""+Queue.getQueueSize());
                    Printer.printLine(6, ""+Queue.getOldQueueSize());
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                    Printer.printLine(7, "Income " + Dispatch.income);
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

                    Dispatch.completeBuyer();
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
                Util.sleep(Util.getRandom(4500, 5500), false);
            } else if ((Market.list.size() != 0) && (Dispatch.cashiersWorking.size() == 1)) {
                Printer.printLine(cashierNumber, "Waiting: ");
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else
                break;
        }
        Dispatch.cashiersWorking.remove(this);
        Dispatch.cashierNumbers[cashierNumber] = 0;
        synchronized (Printer.monitor){
            Printer.printLine(cashierNumber, "Cashier Closed");
        }
    }
}
