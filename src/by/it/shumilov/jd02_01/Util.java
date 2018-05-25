package by.it.shumilov.jd02_01;

public class Util {

    private static final int kTime = 100;

    static int rnd(int start, int stop){
        return  start + ((int)(Math.random()*(stop-start+1)));
    }

    static  void sleep(int timeOut){
        try {
            Thread.sleep(timeOut/kTime);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }


}
