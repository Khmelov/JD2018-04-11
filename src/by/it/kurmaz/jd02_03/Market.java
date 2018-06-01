package by.it.kurmaz.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    static ConcurrentLinkedDeque<Buyer> list = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) {
        System.out.println("Shop is opened");
        Goods.createBucket();
        System.out.println("Bucket is created");
        System.out.println("Wait for 20 sec");
        System.out.println("=================================================================================================================================");
        System.out.println("|  Cashier #1   |   Cashier #2  |   Cashier #3  |   Cashier #4  |   Cashier #5  |   Queue       |  OldQueue     |  Total Income |");
        System.out.println("=================================================================================================================================");

        int counter = 1;
        boolean isOld;
        int second;
        int timer = 0;
        boolean condition;

        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (!Dispatch.planComplete()) {
            second = timer % 60;
            timer++;
            if (second <= 30)
                condition = (list.size() < (second + 10));
            else
                condition = (list.size()< (40 + (30 - second)));
            if (condition) {
                int count = Util.getRandom(1, 2);
                for (int i = 0; !Dispatch.planComplete() && i < count; i++) {
                    isOld = ((Util.getRandom(1, 4)) % 4 == 0);
                    Buyer buyer = new Buyer("# " + counter, isOld);
                    list.add(buyer);
                    buyer.start();
                    counter++;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!Dispatch.enoughCashiers())  {
                int cashierNumber = 0;
                for (int i = 0; i < 5; i++) {
                    if ((Dispatch.cashierNumbers[i]) == 0) {
                        cashierNumber = i;
                        break;
                    }
                }
                Cashier cashier;
                executor.execute(cashier = new Cashier(cashierNumber));
                //System.out.println(Dispatch.cashiersWorking.size());
                Dispatch.cashiersWorking.add(cashier);
            }
        }

        while (Dispatch.cashierWorks()) {
            if (!Dispatch.enoughCashiers())  {
                int cashierNumber = 0;
                for (int i = 0; i < 5; i++) {
                    if ((Dispatch.cashierNumbers[i]) == 0) {
                        cashierNumber = i;
                        break;
                    }
                }
                Cashier cashier;
                executor.execute(cashier = new Cashier(cashierNumber));
                //System.out.println(Dispatch.cashiersWorking.size());
                Dispatch.cashiersWorking.add(cashier);
            }
        }

        executor.shutdown();

        while ((list.size() != 0) || (Dispatch.cashiersWorking.size() != 0)) {
            Util.sleep(1000, false);
        }
        synchronized (Printer.monitor) {
            System.out.println("=================================================================================================================================");
            System.out.println("Shop closed, " + Dispatch.buyerCounter + " buyers served.");
        }
    }
}
