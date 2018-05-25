package by.it.shumilov.jd01_12;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskC1 {
    public static void main(String[] args) {
        String s ="qwert\n" +
                "asdfgf\n" +
                "qwwrtr\n" +
                "zsdfgdg\n" +
                "asdwf\n" +
                "fghyj\n" +
                "dgfhjm\n" +
                "sfsdfj\n" +
                "serdhrfm\n" +
                "dffgj\n" +
                "dhfgjj\n" +
                "dhfjgh\n" +
                "hgggg\n" +
                "ggggg\n" +
                "hgggg\n" +
                "nbn\n" +
                "gf\n" +
                "dfh\n" +
                "nbn\n" +
                "end";
        Map<Long, String> c1 = new TreeMap<>();
        Map<String, Long> c2 = new TreeMap<>();
        Scanner sc=new Scanner(s);
        String line;
        while(!(line = sc.nextLine()).equals("end")){
            while(c1.put(System.nanoTime(),line.trim()) != null){}
        }
        Iterator<Map.Entry<Long,String >> iterator = c1.entrySet().iterator();

        System.out.println(c1);
        while (iterator.hasNext()){
            Map.Entry<Long, String> next = iterator.next();
            c2.put(next.getValue(),next.getKey());

        }
        c1.clear();
        System.out.println(c2);
        Iterator<Map.Entry<String,Long >> iterator2 = c2.entrySet().iterator();
        while (iterator2.hasNext()){

            Map.Entry<String, Long> next = iterator2.next();
            c1.put(next.getValue(),next.getKey());

        }

        System.out.println(c1);

    }

}
