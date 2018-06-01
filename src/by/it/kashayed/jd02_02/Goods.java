package by.it.kashayed.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {


    static int goods (){
        return  (int)(1+Math.random()*5);
    }
   static String  gds () {
        Map<String,Integer> map = new HashMap<>();
        map.put("Колбаса",5);
        map.put("Молоко",2);
        map.put("Хлеб",1);
        map.put("Яйца",2);
       for (int i = 0; i <goods() ; i++) {

       }
        return "";
    }
}
