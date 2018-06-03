package by.it.kashayed.jd02_03;

import java.util.concurrent.Semaphore;

public class Run implements Runnable {
    private static Semaphore semaphore = new Semaphore(20);
    private Buyer name;

    Run(Buyer name) {
        this.name=name;
    }


    @Override
    public String toString() {
        return "" + name +
                ' ';
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
            System.out.println(this+" стал в очередь");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }

    }
}
