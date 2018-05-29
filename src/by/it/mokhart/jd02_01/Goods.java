package by.it.mokhart.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Goods {
    static HashMap<String, Double> goods = new HashMap<>(){
        {
            this.put("Water", 1.5);
            this.put("Bread", 2.22);
            this.put("Sugar", 3.34);
            this.put("Salt",2.78);
        }
    };

    static ArrayList<Map.Entry<String, Double>> goodsList = new ArrayList<>(goods.entrySet());
}
