package by.it.dkruchek.jd01_12;

import java.util.*;

/**
 * Created by Dmitriy.Kruchek on 5/20/2018.
 */
public class TaskC1 {
    public static void main(String[] args) {

        Map<Integer,String> myMap = new TreeMap<>();
        List<String> mlist = new ArrayList<>(Arrays.asList(
                "1", "2", "3", "3", "2", "2", "1"));
        int cypher = 0;
        for (String s : mlist)
            myMap.put(cypher += (Math.random() * 100 + 1), s);
        Map<Integer, String> compressedMap = new TreeMap<>(myMap);
        System.out.println("Original map " + myMap.toString());
        System.out.println("Before compression " + compressedMap.toString());
        Collection<String> values = compressedMap.values();
        Iterator<String> it = values.iterator();
        while (it.hasNext())
            if (Collections.frequency(values,it.next()) > 1)
                it.remove();
        System.out.println("After compression " + compressedMap.toString());
    }
}
