package by.it.kurmaz.jd02_01;

class Util {

    private final static int acc = 50;

    static int getRandom (int start, int stop) {
        return (start + (int)(Math.random()*(stop - start + 1)));
    }

    static void sleep (int timeout) {
        try {
            Thread.sleep(timeout/acc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
