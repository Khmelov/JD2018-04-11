package by.it.rogov.jd02_03;

class Cashiers implements Runnable {

    private static final Object synchronMonitor = new Object();

    private int number;
    private String name;
    private boolean openCashier5 = true;
    private boolean openCashier4 = true;
    private boolean openCashier3 = true;
    private boolean openCashier2 = true;
    private boolean openCashier1 = false;

    Cashiers(int number) {
        this.number = number;
        name = "Кассир №" + number;

    }

    @Override
    public void run() {

        while (Dispetcher.openMarket()) {

            if (BuyerQueue.sizeBuyerInEque() < 21 && number == 5) {
                if (!openCashier5) {
                    System.out.println(name + " закрыл кассу ");
                    openCashier5 = true;
                }
                Util.sleep(10);
            } else if (BuyerQueue.sizeBuyerInEque() < 16 && number == 4) {
                if (!openCashier4) {
                    System.out.println(name + " закрыл кассу ");
                    openCashier4 = true;
                }
                Util.sleep(10);
            } else if (BuyerQueue.sizeBuyerInEque() < 11 && number == 3) {
                if (!openCashier3) {
                    System.out.println(name + " закрыл кассу ");
                    openCashier3 = true;
                }
                Util.sleep(10);
            } else if (BuyerQueue.sizeBuyerInEque() < 6 && number == 2) {
                if (!openCashier2) {
                    System.out.println(name + " закрыл кассу ");
                    openCashier2 = true;
                }
                Util.sleep(10);
            } else if (number == 1) {
                if (!openCashier1) {
                    System.out.println(name + " открыл кассу ");
                    openCashier1 = true;
                }
                serviceBuyer();
            } else {
                if (number == 5) {
                    if (openCashier5) {
                        System.out.println(name + " открыл кассу ");
                        openCashier5 = false;
                    }
                    Util.sleep(10);
                    serviceBuyer();
                }
                if (number == 4) {
                    if (openCashier4) {
                        System.out.println(name + " открыл кассу ");
                        openCashier4 = false;
                    }
                    Util.sleep(10);
                    serviceBuyer();
                }
                if (number == 3) {
                    if (openCashier3) {
                        openCashier3 = false;
                        System.out.println(name + " открыл кассу ");
                    }
                    Util.sleep(10);
                    serviceBuyer();
                }
                if (number == 2) {
                    if (openCashier2) {
                        openCashier2 = false;
                        System.out.println(name + " открыл кассу ");
                    }
                    Util.sleep(10);
                    serviceBuyer();
                }
            }
        }
        if (number == 1) System.out.println(name + " закрыл кассу ");
    }

    public void serviceBuyer() {
        Buyer buyer = BuyerQueue.extractBuyerFromEqeue();
        if (buyer != null) {
            System.out.println(this + " обслуживает " + buyer);
            Util.sleep(Util.rnd(2000, 5000));
            System.out.println(this + " пробил " + buyer.getGoodsInBacket().replace("{", "[")
                    .replace("}", "]") + buyer);
            System.out.printf(this + " завершил обслживание " + buyer + " Итоговая сумма покупoк: %.1f  \n", buyer.sum);
            Dispetcher.completBuer();
            synchronized (buyer) {
                buyer.notify();
            }
        } else
            Util.sleep(10);
    }

    @Override
    public String toString() {
        return name;
    }
}
