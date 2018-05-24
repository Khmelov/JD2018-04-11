package by.it.tayanovskii.jd01_12;

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
            if (result == null)
                result = new HashSet<>(set);
            else
                result.retainAll(set);
        }
        return result;
    }


    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,5,5,6,6,7,7,8,8));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,5,6,6,7,7,8,8,8,9,9,10));
        System.out.println("union = " + getUnion(a,b));
        System.out.println("cross = " + getCross(a,b));
    }

}
