package by.it.kashayed.jd02_02.jd02_02new;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

class Runner {

    static List<Buyer> allBuyer = new ArrayList<Buyer>() ;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Goods.food(scanner);
        int number=1;
        System.out.println("Магазин открыт");

        for (int i = 1; i <=2 ; i++) {
           Thread cashier = new Thread(new Cashier(i));
           cashier.start();
        }
        while(!Dispatcher.planComplete()) {
            int count = Rnd.rnd(0, 2);
            for (int i = 0; !Dispatcher.planComplete()&& i < count; i++) {
                Buyer buyer=new Buyer(number++);
                Dispatcher.addBuyer();
                allBuyer.add(buyer);
                buyer.start();
            }
            Rnd.sleep(1000);
        }
        for (Buyer buyer : allBuyer) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Магазин закрыт");
    }

}
