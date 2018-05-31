package by.it.rogov.jd02_02;

 class Cashiers implements Runnable {

     private static final Object synchronMonitor = new Object();

    private int number;
    private String name;
     private volatile boolean openCashier4;
     private volatile boolean openCashier5;
     private volatile boolean openCashier3;
     private volatile boolean openCashier2;

    Cashiers(int number) {
        this.number = number;

        name = "Кассир №" + number;

    }


    @Override
    public void run() {
        System.out.println(name+ " открыл кассу");
        while (Dispetcher.openMarket()) {
            Buyer buyer = BuyerQueue.extractBuyerFromEqeue();
            if(number==5&&BuyerQueue.sizeBuyerInEque()<21){
                try {
                    Thread.sleep(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(openCashier5) {
                    System.out.println(name + "закрыл кассу временно");
                    openCashier5=false;
                }
            }else if(number==4&&BuyerQueue.sizeBuyerInEque()<16){
                try {
                    Thread.sleep(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(openCashier4) {
                    System.out.println(name + "закрыл кассу временно");
                    openCashier4=false;
                }
            }else if(number==3&&BuyerQueue.sizeBuyerInEque()<11){
                try {
                    Thread.sleep(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(openCashier3) {
                    System.out.println(name + "закрыл кассу временно"+BuyerQueue.sizeBuyerInEque());
                    openCashier3=false;
                }
            }else if(number==2&&BuyerQueue.sizeBuyerInEque()<6){
                try {
                    Thread.sleep(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(openCashier2) {
                    System.out.println(name + "закрыл кассу временно");
                    openCashier2=false;
                }
            }else if(number==1){

            }else {
                if(number==5)
                openCashier5=true;
                if(number==4)
                openCashier4=true;
                if(number==3)
                openCashier3=true;
                if (number==2)
                openCashier2=true;
            }

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
            System.out.println(name + "закрыл кассу" );

        }
    @Override
    public String toString() {
        return name;
    }
}
