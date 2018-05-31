package by.it.kashayed.jd02_02.jd02_02new;

class Rnd {

    static int rnd(int start, int stop) {
        return start + ((int) (Math.random() * (stop - start + 1)));
    }
    static void sleep(int sleep){
        try {
            Thread.sleep(sleep/100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
