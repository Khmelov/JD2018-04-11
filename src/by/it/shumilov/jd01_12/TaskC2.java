package by.it.shumilov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {


        public static void main(String[] args) {
            Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,3,34,5,6,64,3,4,5,5,6,112));
            Set<Integer> a1 = new HashSet<>(Arrays.asList(1,2,3,4,3,34,5,6,64,3,4,11,5,99,112));
            Set<Integer> b = new TreeSet<>(Arrays.asList(1,2,3,4,9,34,5,5,64,3,4,34,5,6,98));
            Set<Integer> b2 = new TreeSet<>(Arrays.asList(1,2,3,4,9,34,53,5,64,3,23,34,5,6,98));
            System.out.println("a=" + a);
            System.out.println("b=" + b);
            System.out.println("union=" + getUnion(a,b,a1,b2));
            System.out.println("cross=" + getCross(a,b,a1,b2));
        }


        static <T extends  Number>  Set<T>  getCross(Set<T>... a){
            Set<T> c = new HashSet<>(a[0]);
            for (int i = 1; i < a.length; i++) {
                c.retainAll(a[i]);
            }


            return c;
        }

        static <T extends  Number>  Set<T> getUnion(Set<T>... a){

            Set<T> c = new HashSet<>(a[0]);
            for (int i = 1; i < a.length; i++) {
                c.addAll(a[i]);
            }
            return c;

        }


}
