package by.it.tayanovskii.jd02_01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Goods {

    HashMap<String, Double> goods = new HashMap<>();

    public Goods() {
        goods.put("хлеб", 1.0);
        goods.put("батон", 1.1);
        goods.put("молоко", 1.2);
        goods.put("сметана", 0.9);
        goods.put("яйца", 1.5);
        goods.put("сыр", 2.1);
        goods.put("колбаса", 3.2);
        goods.put("вода", 1.11);
    }

    String putRandomGoods() {
        int randomIndex = Util.rnd(0, goods.size() - 1);
        String result = "";
        for (Map.Entry<String, Double> entry : goods.entrySet()) {
            if (randomIndex == 0)
                result = entry.getKey() + " " + entry.getValue();
            randomIndex--;
        }
        return result;
    }


}
