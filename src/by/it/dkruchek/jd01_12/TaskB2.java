package by.it.dkruchek.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Dmitriy.Kruchek on 5/17/2018.
 */

public class TaskB2 {

    static String process(ArrayList<String> peoples){
        int index = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (index % 2 > 0) iterator.remove();
                index++;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int index = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (index % 2 > 0) iterator.remove();
                index++;
            }
        }
        return peoples.get(0);
    }
}
