package by.it.shumilov.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Util {

    static  Map<String,Double> Goods = new HashMap<String,Double>(){{
        put("молоко",  1.2);
        put("чай", 2.6);
        put("хлеб",   1.1);
        put("пельмени",  3.0);
        put("батон", 1.5);
        put("конфеты",  34.8);
        put("гречка", 20.1);
        put("колбаса",33.3);
        put("творог",   1.5);
        put("сыр",  18.4);
        put("кровать", 156.1);
        put("акваланг",   345.9);
    }};

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
    static  void sleep(int timeOut, boolean pensioner){
        sleep((int) (timeOut*1.5));
    }


}
