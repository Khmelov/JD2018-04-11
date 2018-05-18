package by.it.dkruchek.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Dmitriy.Kruchek on 5/18/2018.
 */
public class TaskC2 {
    @SafeVarargs
    private static <T extends Number> Set<T> getUnion(Set<T> ... sets){
        Set<T> result = new HashSet<>();
        for (Set<T> set : sets) result.addAll(set);
        return result;
    }
    @SafeVarargs
    private static <T extends Number> Set<T> getCross(Set<T> ... sets){
        Set<T> result = new HashSet<>(sets[0]);
        for (Set<T> set : sets) result.retainAll(set);
        return result;
    }

    public static void main(String[] args) {

        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 21));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 21, 22, 23, 6));
        HashSet<Double> c = new HashSet<>(Arrays.asList(99.99, 99.1, 98.2, 98.1));
        TreeSet<Double> d = new TreeSet<>(Arrays.asList(99.1, 97.2, 100.00));

        System.out.println(getCross(a, b));
        System.out.println(getUnion(c, d));

    }

}
