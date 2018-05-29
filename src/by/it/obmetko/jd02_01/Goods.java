package by.it.obmetko.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods extends HashMap<String, Double> {

    private static Goods goods = new Goods() {
        {
            this.put("Хлеб", 2.0);
            this.put("Сметана", 1.5);
            this.put("Соль", 0.8);
            this.put("Молоко", 2.0);
            this.put("Ананас",7.0);
        }
    };


    static ArrayList<Entry<String, Double>> productList = new ArrayList<>(goods.entrySet());

    static List<String> rndGoodName() {
        List<String> names = new ArrayList<>(goods.keySet());
        return names;
    }
}





