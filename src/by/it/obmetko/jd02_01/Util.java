package by.it.obmetko.jd02_01;


public class Util {
    static void sleep(int msTimeout) {
        try {
            Thread.sleep(msTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static int random(int from, int to) {
        return from + (int) (Math.random() * (1 + to - from));
    }

   public static int random(int count) {
        return random(0, count);
    }

}