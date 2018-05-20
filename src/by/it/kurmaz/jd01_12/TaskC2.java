package by.it.kurmaz.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(10, 11, 12, 9, 8, 7, 6, 15));
        HashSet<Double> c = new HashSet<>(Arrays.asList(4.5, 5.5, 6.5, 8.5));
        TreeSet<Double> d = new TreeSet<>(Arrays.asList(15.5, 6.5, 5.5, 9.5));

        System.out.println(getCross(a, b));
        System.out.println(getUnion(c, d));
    }

    @SafeVarargs
    private static Set<? extends Number> getCross(Set<? extends Number>... set) {
        HashSet<Number> result = new HashSet<>(set[0]);
        for (int i = 1; i < set.length; i++) {
            result.retainAll(set[i]);
        }
        return result;
    }

    @SafeVarargs
    private static Set<? extends Number> getUnion(Set<? extends Number> ... set){
        HashSet<Number> result= new HashSet<>(set[0]);
        for (int i = 1; i < set.length; i++) {
            result.addAll(set[i]);
        }
        return result;
    }
}
