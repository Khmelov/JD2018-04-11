package by.it.mokhart.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(1, 11, 2, 3, 4, 22, 5, 6, 10, 11, 7, 8, 9));

        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set2);
        result.retainAll(set1);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set2);
        result.addAll(set1);
        return result;
    }
}
