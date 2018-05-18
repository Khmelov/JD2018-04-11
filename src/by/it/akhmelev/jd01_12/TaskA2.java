package by.it.akhmelev.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> a=new TreeSet<>(Arrays.asList(1,2,3,4,5,5,6,6,7,7,8,8));
        Set<Integer> b=new HashSet<>(Arrays.asList(5,5,6,6,7,7,8,8,8,9,9,112));
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("union="+getUnion(a,b));
        System.out.println("cross="+getCross(a,b));
    }

}
