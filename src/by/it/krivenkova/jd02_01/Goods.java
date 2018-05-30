package by.it.krivenkova.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Goods {
    static HashMap<String, Double> products = new HashMap<>() {
        {
            this.put("мясо", 3.75);
            this.put("хлеб", 1.25);
            this.put("молоко", 1.75);
            this.put("рыба", 2.75);
        }
    };

    static ArrayList<Map.Entry<String, Double>> productList = new ArrayList<>(products.entrySet());
}
