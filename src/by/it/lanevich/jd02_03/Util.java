package by.it.lanevich.jd02_03;

class Util {

    private static final int kTime=100;

    static int rnd(int start, int stop) {
        return start + ((int) (Math.random() * (stop - start + 1)));
    }
    static int rnd(int start, int stop, double speed) {
        return (int)((start + ((int) (Math.random() * (stop - start + 1))))*speed);
    }


    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/kTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}