package by.it.tayanovskii.jd01_12;

import java.util.*;

public class TaskB2 {


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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имена (через пробел)");
        String names = scanner.nextLine();
        String[] listArray = names.split(" ");

        ArrayList<String> listA = new ArrayList<>(Arrays.asList(listArray));
        LinkedList<String> listL = new LinkedList<>(Arrays.asList(listArray));
        String nameA = process(listA);
        System.out.println("ListArray: " + nameA);
        String nameL = process(listL);
        System.out.println("LinkedList: " + nameL);

    }


}
