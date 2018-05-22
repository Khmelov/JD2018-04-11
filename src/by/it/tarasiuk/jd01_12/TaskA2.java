package by.it.tarasiuk.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new TreeSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }


    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 48, 5, 9, 8, 6));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(10, 22, 31, 4, 5, 9, 8, 6));
        System.out.println("TreeSet: " + treeSet + "\nHashSet: " + hashSet);
        System.out.println("UnionSet: " + getUnion(treeSet, hashSet));
        System.out.println("CrossSet: " + getCross(treeSet, hashSet));
    }

}
