package by.it.kashayed.jd02_02.jd02_02new;

import java.util.HashMap;

public class Goods {


    private static int goods = Rnd.rnd(1,4);
    static int sum =0;

    static String food(int numberGoods){

        HashMap<String, Integer> mapgoods = new HashMap<>();
        mapgoods.put("Хлеб",2);
        mapgoods.put("Молоко",1);
        mapgoods.put("Яйца",3);
        mapgoods.put("Колбаса",4);
        String [] goods = new String[4];
        goods[0]="Хлеб";
        goods[1]="Молоко";
        goods[2]="Яйца";
        goods[3]="Колбаса";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String delimiter="";
        sum=0;
        if (numberGoods<=goods.length) {
            for (int i = 0; i < numberGoods; i++) {
                sb.append(delimiter).append(goods[i]).append("=").append(mapgoods.get(goods[i]));
                delimiter=" ";
                sum+=mapgoods.get(goods[i]);
            }

        }
        sb.append("]");


        return sb.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(food(3));
//    }

}
