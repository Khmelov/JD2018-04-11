package by.it.shekh.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    private static <T extends Number> Set<T> getUnion(Set<T>... a) {
        Set<T> result = new HashSet<>();
        for (Set<T> set : a) {
            result.addAll(set);
        }
        return result;
    }

    private static <T extends Number> Set<T> getCross(Set<T>... a) {
        Set<T> result = null;
        for (Set<T> set : a) {
            if (result == null) {
                result = new HashSet<>(set);
            } else
                result.retainAll(set);
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8));
        Set<Integer> b = new HashSet<>(Arrays.asList(5, 5, 6, 6, 7, 7, 8, 8, 8, 9, 9, 112));
        Set<Integer> c = new TreeSet<>(Arrays.asList(1, 22, 3, 44, 5, 5, 67, 6, 7, 7, 85, 8));
        Set<Integer> d = new HashSet<>(Arrays.asList(5, 5, 6, 6, 7, 67, 8, 8, 85, 9, 95, 112));
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
        System.out.println("d=" + d);
        System.out.println("union=" + getUnion(a, b, c, d));
        System.out.println("cross=" + getCross(a, b, c, d));
    }
}
