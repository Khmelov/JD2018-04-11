package by.it.tayanovskii.jd01_12;

import java.util.*;

public class TaskB2 {




    private static String process(ArrayList<String> peoples) {
        LinkedList<String> linkedList = new LinkedList<>(peoples);
        return prоcess(linkedList);
    }

    private static String prоcess(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        if (!iterator.hasNext())
            return null;
        int countPeople = peoples.size();
        while (countPeople > 1) {
            iterator=peoples.iterator();
            boolean isDeleted=true;
            while (iterator.hasNext()) {
                if(isDeleted) iterator.next();
                if(iterator.hasNext())
                {
                    iterator.next();
                    iterator.remove();;
                    isDeleted=true;
                    countPeople--;
                }
                else isDeleted=false;

            }
        }
        return peoples.get(0);


//        int count = 0;
//        Iterator it = peoples.iterator();
//        while(peoples.size() > 1) {
//            if(it.hasNext()) {
//                it.next();
//                count++;
//                if(count == 2) {
//                    it.remove();
//                    count = 0;
//                }
//            }
//            else {
//                it = peoples.iterator();
//            }
//        }
//    return peoples.get(0);

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имена (через пробел)");
        String names = scanner.nextLine();
        String[] listArray = names.split(" ");

        ArrayList<String> listA = new ArrayList<>(Arrays.asList(listArray));
        LinkedList<String> listL = new LinkedList<>(Arrays.asList(listArray));
        String nameA = process(listA);
        System.out.println("Имя из ListArray: " + nameA);
        String nameL = prоcess(listL);
        System.out.println("Имя из LinkedList: " + nameL);

    }


}
