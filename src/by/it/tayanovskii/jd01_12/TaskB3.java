package by.it.tayanovskii.jd01_12;

import java.util.*;

public class TaskB3 {

    private static String process(ArrayList<String> peoples) {

        boolean isDeleted = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if (isDeleted) {
                    iterator.remove();
                }
                isDeleted = !isDeleted;
            }

        }

        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        boolean isDeleted = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if (isDeleted) {
                    iterator.remove();
                }
                isDeleted = !isDeleted;
            }

        }

        return peoples.get(0);
    }


    public static void main(String[] args) {

        List<String> listArray = new ArrayList<>();
        for (int i = 0; i < 4095; i++) {
            listArray.add("v"+i);
        }

        ArrayList<String> listA = new ArrayList<>(listArray);
        LinkedList<String> listL = new LinkedList<>(listArray);
        String nameA = process(listA);
        System.out.println("ListArray: " + nameA);
        String nameL = process(listL);
        System.out.println("LinkedList: " + nameL);

    }

}
