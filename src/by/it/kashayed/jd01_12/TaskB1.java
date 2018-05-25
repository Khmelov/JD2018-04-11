package by.it.kashayed.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sc;
        Pattern pattern = Pattern.compile("[a-zA-Z]+['a-zA-Z]*");
        Map<String, Integer> map = new HashMap<String, Integer>();
            while (!(sc = scanner.next()).equals("end")){
                Matcher matcher = pattern.matcher(sc);
                while (matcher.find()){
                    if (map.containsKey(matcher.group()))
                        map.put(matcher.group(),map.get(matcher.group())+1);
                    else map.put(matcher.group(),1);
                }
            }
            System.out.println(map);
        }
}
