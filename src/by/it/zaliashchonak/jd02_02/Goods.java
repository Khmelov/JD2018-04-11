package by.it.zaliashchonak.jd02_02;


import java.util.HashMap;

public class Goods {
    HashMap<String, Double> goods = new HashMap<>();

    public Goods() {
        goods.put("Товар1", 1.00);
        goods.put("Товар2", 1.50);
        goods.put("Товар3", 2.00);
        goods.put("Товар4", 2.99);
        goods.put("Товар5", 4.00);

    }

    public String takeGood() {
        int randomGood = Util.random(0, goods.size() - 1);
        for (String good : goods.keySet()) {
            if(randomGood == 0)
                return good + "/"+goods.get(good).toString();
            randomGood--;
        }
        return null;
    }

}