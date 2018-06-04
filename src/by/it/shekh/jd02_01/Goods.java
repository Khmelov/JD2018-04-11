package by.it.shekh.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goods {
    public static Map<String, Double> goodsMap = new HashMap<String, Double>();

    static void addGoodsToShop() {
        goodsMap.put("Абрикос", 4.10);
        goodsMap.put("Апельсин", 2.30);
        goodsMap.put("Батон", 1.09);
        goodsMap.put("Масло", 2.19);
        goodsMap.put("Гречка", 1.14);
        goodsMap.put("Рис", 1.80);
        goodsMap.put("Сыр", 10.12);
        goodsMap.put("Яйца", 2.20);
    }

    static String getRndProduct() {
        List<String> valuesList = new ArrayList<String>(goodsMap.keySet());
        int rndNum = Util.rnd(0, valuesList.size() - 1);
        return valuesList.get(rndNum);
    }
}
