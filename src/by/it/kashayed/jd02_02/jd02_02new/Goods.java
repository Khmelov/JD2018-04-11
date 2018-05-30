package by.it.kashayed.jd02_02.jd02_02new;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Goods {
    private static int goods = Rnd.rnd(1,4);



    static String food(Scanner string){

        Map<String, Integer> mapgoods = new HashMap<>();
        String[] s =string.next().split(" ");
        String key = s[0];
        Integer value = Integer.parseInt(s[1]);
        mapgoods.put(key,value);
//        mapgoods.put("Хлеб",2);
//        mapgoods.put("Молоко",1);
//        mapgoods.put("Колбаса",4);
//        mapgoods.put("Яйца",3);

        return "";
    }

}
