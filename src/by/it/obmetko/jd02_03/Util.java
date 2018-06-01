package by.it.obmetko.jd02_03;

class Util {
    static void sleep(int msTimeout) {
        try {
            Thread.sleep(msTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static int random(int from, int to) {
        return from + (int) (Math.random() * (1 + to - from));
    }

}