package by.it.rogov.jd02_02;

 class Cashiers implements Runnable {

     private static final Object synchronMonitor = new Object();

    private int number;
    private String name;
    private boolean openCashier;

    Cashiers(int number) {
        this.number = number;
        this.openCashier=false;
        name = "Кассир №" + number;

    }


    @Override
    public void run() {

        while (Dispetcher.openMarket()) {
            Buyer buyer = BuyerQueue.extractBuyerFromEqeue();
            if((BuyerQueue.sizeBuyerInEque()>20)&&number==5){
                if(!openCashier) {
                    System.out.println(this + " открыл кассу");
                    openCashier = true;
                }


//            }else if(BuyerQueue.sizeBuyerInEque()<15&&name.equals("Кассир №4")){
//                if(!openCashier) {
//                    System.out.println(this + "открыл кассу");
//                    openCashier=true;
//                }
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }else if(BuyerQueue.sizeBuyerInEque()<10&&name.equals("Кассир №3")){
//                if(!openCashier) {
//                    System.out.println(this + "открыл кассу");
//                    openCashier=true;
//                }
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }else if(BuyerQueue.sizeBuyerInEque()<5&&name.equals("Кассир №2")){
////                if(!openCashier) {
////                    System.out.println(this + "открыл кассу");
////                    openCashier=true;
////                }
////                try {
////                    this.wait();
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }else if(BuyerQueue.sizeBuyerInEque()<0&&name.equals("Кассир №1")){
//                if(!openCashier) {
//                    System.out.println(name + "открыл кассу");
//                    openCashier=true;
//                }
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }else {
                if(openCashier) {
                    System.out.println(name + " закрыл кассу");
                    openCashier = false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
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

        System.out.println(name + "закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
