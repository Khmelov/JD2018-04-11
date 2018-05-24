package by.it.shekh.jd01_12;

import java.util.*;

public class TaskB3 {
    private static String process(ArrayList<String> peoples) {
        boolean deleted = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (deleted) {
                    iterator.remove();
                }
                deleted = !deleted;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        boolean deleted = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (deleted) {
                    iterator.remove();
                }
                deleted = !deleted;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        final List<String> nameList = Arrays.asList("Artem", "Andrew", "Aleksandr", "Denis", "Ivan", "Roman", "Sergey", "Igor", "Vasiliy", "Eugeny", "Olga", "Kate", "Nastya", "Oksana");
        final int peopleNumber = 4096;
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < peopleNumber; i++) {
            arrayList.add(nameList.get(
                    (int)
                            (Math.random() * 13 + 1))
            );
            linkedList.add(nameList.get(
                    (int)
                            (Math.random() * 13 + 1))
            );
        }

        System.out.println("Тестирование ArrList");
        long iniTime = System.nanoTime();
        System.out.println(process(arrayList));
        long delta = (System.nanoTime()-iniTime)/1000;
        System.out.println("Прошло времени: "+delta+" микросекунд");

        System.out.println("Тестирование LinkedList");
        iniTime = System.nanoTime();
        System.out.println(process(linkedList));
        delta = (System.nanoTime()-iniTime)/1000;
        System.out.println("Прошло времени: "+delta+" микросекунд");
    }
}
