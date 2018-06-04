package by.it.kasiyanov.jd02_03;

public class Util {

    private static int kTime = 100;
    private static double kPensioner = 1.5;

    static int rnd(int from, int to){
        return from + ((int)(Math.random()*(to - from + 1)));
    }

    static void sleep (int timeout){
        try {
            Thread.sleep(timeout/kTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep (int timeout, boolean pensioner){
        try {
            if (pensioner){
                Thread.sleep((int)(timeout * kPensioner/kTime));
            }
            else Thread.sleep(timeout/kTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
