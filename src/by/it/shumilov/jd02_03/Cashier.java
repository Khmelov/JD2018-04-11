package by.it.shumilov.jd02_03;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cashier extends Thread{

    private  int number;

    private  String name;

    private  boolean open = true;

    public Cashier(int number){
        this.number = number;
        name = "Кассир № " + number;
    }

    @Override
    public void run() {

        System.out.println("Открыл кассу " + number);

        while (open && Dispatcher.openedMarket()){/////////////////////////////////////
            Buyer buyer = BuyerQueue.extractBuyerFromQueue();


            if(buyer !=null){
                int sizeQueue = BuyerQueue.getSize();
                String indent = "|";
                String indentEnd = "";
                String tire = "--------------------------|";





                for (int i = 0; i < 5- number; i++) {
                    indentEnd += tire;
                }

                for (int i = 0; i < number-1; i++) {
                    indent += tire;
                }



                synchronized (System.out){


                    System.out.println(indent+this + " обслуживает " + buyer);
                    Util.sleep(Util.rnd(2000,5000));



                    HashMap<String,Double> backet = new HashMap(buyer.getBacket()); //// concurent?

                    System.out.println(indent+"--------------------------|" +indentEnd + "--------------|--------------------");
                    System.out.printf(indent  + "%26s|" + indentEnd + "--------------|--------------------\n",buyer);
                    System.out.println(indent + "-" + "купил следующее:---------|" + indentEnd + "Размер очереди|" + "Общая сумма магазина");


                    double sum = 0;


                    for (Map.Entry<String, Double> entry : backet.entrySet()) {
                        sum +=entry.getValue();
                        System.out.printf("%s-%-10s : %-12.2f|%s--------------|--------------------\n",indent,entry.getKey(), entry.getValue(),indentEnd);
                    }
                    BuyerQueue.addSum(sum);
                    System.out.printf(indent+"-------Итого: %-12.2f|%s%14d|%20.2f\n" ,sum,indentEnd,sizeQueue,BuyerQueue.getSumMarket());
                    System.out.println(indent+"--------------------------|"+indentEnd + "--------------|--------------------");


                    System.out.println(indent+this + " закончил обслуживание " + buyer);
                }


                Dispatcher.comleteBuyer();

                synchronized (buyer){
                    buyer.notify();
                }

            }
            else
                Util.sleep(10);

            if ( (int) Math.ceil(BuyerQueue.getSize()/5.0) < this.number)
                this.open = false;
        }

        System.out.println(name + " закрыл кассу");

        Dispatcher.delCashier();

//        System.out.println("---------------------------------------buers in shop " + Dispatcher.getcountBuyerInShop());
//        System.out.println("---------------------------------------buers in queue " + BuyerQueue.getSize());
//        System.out.println("---------------------------------------cassirs " + Dispatcher.getCountCashier());
//        System.out.println("---------------------------------------open market " + Dispatcher.openedMarket());
    }
    public void closeCassa(){
        this.open = false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}