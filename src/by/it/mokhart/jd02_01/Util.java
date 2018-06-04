package by.it.mokhart.jd02_01;

public class Util {

    private static final int kTime = 100;
    private static double kPensioneer = 1.5;

    static int rnd(int start, int stop) {
        return start + ((int) (Math.random() * (stop - start + 1)));
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / kTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep(int timeout, boolean pensioneer) {
        try {
            if (pensioneer) {
                Thread.sleep((int) (timeout * kPensioneer / kTime));
            } else Thread.sleep(timeout / kTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}