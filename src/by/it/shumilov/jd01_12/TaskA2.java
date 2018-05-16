package by.it.shumilov.jd01_12;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,3,34,5,6,64,3,4,5,5,6,112));
        Set<Integer> b = new TreeSet<>(Arrays.asList(1,2,3,4,9,34,5,5,64,3,4,34,5,6,98));;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("union=" + getUnion(a,b));
        System.out.println("cross=" + getCross(a,b));
    }


    static  Set<Integer>  getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> c = new HashSet<>(a);
        c.retainAll(b);
        return c;
    }

    static  Set<Integer>  getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> c = new HashSet<>(a);
        c.addAll(b);
        return c;
    }
}
