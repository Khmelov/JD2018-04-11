package by.it.tarasiuk.jd02_03;

import java.util.HashMap;

class Goods {
    static HashMap<String, Double> goodsInMarket;

    static {
        goodsInMarket = new HashMap<>();
        goodsInMarket.put("Хлеб", 0.49);
        goodsInMarket.put("Молоко", 1.05);
        goodsInMarket.put("Масло", 2.29);
        goodsInMarket.put("Мясо", 8.39);
        goodsInMarket.put("Рыба", 4.19);
        goodsInMarket.put("Рис", 1.09);
        goodsInMarket.put("Гречка", 0.75);
    }
}
