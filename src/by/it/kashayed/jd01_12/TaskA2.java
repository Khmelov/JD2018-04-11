package by.it.kashayed.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,2,3,4,5,6,6,3,2,12,43,2));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(6,7,8,9,0,9,6,3,2,12,43,2));
        System.out.println(treeSet);
        System.out.println(hashSet);
        System.out.println(getCross(treeSet,hashSet));
        System.out.println(getUnion(treeSet,hashSet));
    }
}
