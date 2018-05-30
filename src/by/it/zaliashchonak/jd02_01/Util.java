package by.it.zaliashchonak.jd02_01;


import java.util.Random;

class Util {

    private static final int kTime=100;
    private final static Random RANDOM = new Random();

    static int rnd(int start, int stop) {
        return start + RANDOM.nextInt(stop - start);
    }

    static int rnd(int bound) {
        return RANDOM.nextInt(bound);
    }

    static void sleep(int start, int stop) {

        try {
            Thread.sleep(Util.rnd(start, stop));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}