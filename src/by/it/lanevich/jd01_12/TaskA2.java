package by.it.lanevich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> res=new HashSet<>(one);
        res.addAll(two);
        return res;

    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
        Set<Integer> res=new HashSet<>(one);
        res.retainAll(two);
        return res;

    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,2,3,4,4,4,5,5,6,6));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(9,8,7,4,4,4,5,5,6,6));
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));


    }

}
















