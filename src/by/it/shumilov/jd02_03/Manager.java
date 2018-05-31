package by.it.shumilov.jd02_03;




import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Manager implements Runnable {


    @Override
    public void run() {
        System.out.println("Манеджер стартанул");

        int maxCountCas  = 2;///////////////count cashier who may work
        //int schet = 0;
        ExecutorService executor = Executors.newFixedThreadPool(maxCountCas);


        while (Dispatcher.openedMarket()){

            int sizeBuyerQueue = BuyerQueue.getSize();
            int count =  Dispatcher.getCountCashier();
            if((count<maxCountCas ) && ((int) Math.ceil(sizeBuyerQueue/5.0) > count)){
//                System.out.println("*************************************************** " + ++schet);
//                System.out.println("*************************************************** " + count + " " + sizeBuyerQueue);
                executor.execute(new Cashier(++count));
                Dispatcher.addCashier();
                Util.sleep(2000);  //пока запуститься создасться много дополнительных Кассиров
            }
            Util.sleep(10);

        }

        executor.shutdown();


        System.out.println("Манеджер закончил");

        //executor.shutdownNow();  ///////////крайний случай
    }

}