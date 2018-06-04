package by.it.dkruchek.jd02_02;

/**
 * Created by Dmitriy.Kruchek on 5/25/2018.
 */
class Util {

    private static final int kTime = 1;

    static int rnd(int start, int stop){
        return start + (int) (Math.random() * (stop - start + 1));
    }

    static void sleep(int timeout){
        try {
            Thread.sleep((timeout / kTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void buyerOperationWait(int start, int stop, boolean isPensioneer) {
        double speed = isPensioneer ? 1.5 : 1;
        sleep((int)(rnd(start, stop) / kTime * speed));
    }
}
