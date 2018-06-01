package by.it.zaliashchonak.jd02_01;



import java.util.ArrayList;
import java.util.List;

public class Market {

    static List<Buyer> allBuyers=new ArrayList<>();


    public static void main(String[] args) {
        int number=0;
        System.out.println("Магазин открыт");
        for (int time = 0; time < 120; time++) {
            int count= Util.rnd(0,2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                allBuyers.add(buyer);
                buyer.start();
                //
            }
            try {
                Thread.sleep(1000/100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Buyer buyer : allBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}