package by.it.kurmaz.jd02_03;

import java.util.EnumMap;
import java.util.HashMap;

class Goods {

    private enum foods {MILK, BREAD, SUGAR, BEER, VODKA, PORK, CONDOMS}
    private static EnumMap<foods, Integer> goods = new EnumMap<>(foods.class);

    static void createBucket() {
        for (int i = 0; i < foods.values().length; i++) {
            goods.put(foods.values()[i], Util.getRandom(10, 50));
        }
    }

    static HashMap<String, Integer> takeGoods() {
        HashMap<String, Integer> goodsToBucket = new HashMap<>();
        int qnt = Util.getRandom(1, 4);
        for (int i = 0; i < qnt; i++) {
            int foodToPut = Util.getRandom(0, (foods.values().length - 1));
            String food = String.valueOf(foods.values()[foodToPut]);
            goodsToBucket.put(food, goods.get(foods.valueOf(food)));
        }
        return goodsToBucket;
    }

}
