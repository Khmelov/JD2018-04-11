package by.it.kurmaz.jd02_03;

class Util {

    private final static int acc = 1;

    static int getRandom (int start, int stop) {
        return (start + (int)(Math.random()*(stop - start + 1)));
    }

    static void sleep (int timeout, boolean old) {
        double speed = 1.0;
        if (old)
            speed = 1.5;
        try {
            Thread.sleep((long) (timeout*speed/acc));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
