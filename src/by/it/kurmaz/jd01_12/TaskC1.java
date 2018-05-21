package by.it.kurmaz.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        Scanner scanner = new Scanner (System.in);
        String line;
        while (!(line = scanner.nextLine()).equals("end")) {
            String pattern = "[^A-Z]+";
            String[] values = line.split(pattern);
            for (String value: values) {
                Set<Integer> keys = map.keySet();
                if (value.length() != 0) {
                    Integer randomValue = (int)(Math.random() * 100000);
                    Integer key = randomValue.hashCode();
                    while(keys.contains(key)) {
                        randomValue = (int)(Math.random() * 100000);
                        key = randomValue.hashCode();
                    }
                    map.put(key, value);
                }
            }
        }
        System.out.println(map);
        Set<String> hash = new HashSet<>(map.values());
        //System.out.println(hash);
        Collection<String> values = map.values();
        //System.out.println(values);
        Iterator iter = hash.iterator();
        while (iter.hasNext()) {
            int counter = 0;
            String value  = (String) iter.next();
            Iterator iterator = values.iterator();
            while (iterator.hasNext()) {
                String compare = (String) iterator.next();
                if (compare.equals(value))
                    counter++;
                if (counter > 1) {
                    iterator.remove();
                    counter--;
                }
            }
        }
        System.out.println(map);
    }
}
