package by.it.zaleschonok.jd02_01;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods extends HashMap<String, Double> {



    private static Goods goodPrice = new Goods() {
        {
            this.put("Товар1", 1.0);
            this.put("Товар2", 1.3);
            this.put("Товар3", 0.7);
            this.put("Товар4", 2.0);
        }
    };

    private Goods() {

    }

    static Double getPrice(String name) {
        return goodPrice.get(name);
    }

    static String rndGood() {
        List<String> names = new ArrayList<>(goodPrice.keySet());
        return names.get(Util.rnd(names.size()));
    }
}