package by.it.rogov.jd01_12;

import java.util.*;

public class TaskB2 {


    static String process(ArrayList<String> peoples) {

        int i = 0;

        List<String> list = new ArrayList<>(peoples);

        while (list.size() > 1) {

            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()) {

                iterator.next();

                if (i % 2 > 0) iterator.remove();

                i++;

            }

        }

        String str = list.get(0);

        return str;

    }


    static String process(LinkedList<String> peoples) {

        int i = 0;

        LinkedList<String> list = new LinkedList<>(peoples);

        while (list.size() > 1) {

            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()) {

                iterator.next();

                if (i % 2 > 0) iterator.remove();

                i++;

            }

        }

        String str = list.get(0);

        return str;

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "30", "4", " 6", "4");
        ArrayList<String> listArray = new ArrayList<>(list);
        LinkedList<String> listLink = new LinkedList<>(list);
        System.out.println("ArrayList: " + process(listArray));
        System.out.println(("LinkedList " + process(listLink)));


    }
}
