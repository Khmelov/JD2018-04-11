package by.it.dkruchek.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/16/2018.
 */
public class TaskA3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        int pos = 0;
        List<Integer> list = new ArrayList<>();
        while (! (s = sc.next()).equals("end")){
            Integer i = Integer.valueOf(s);
            if (i > 0) list.add(pos++, i);
            else if (i < 0) list.add(i);
            else list.add(pos, i);
        }
        System.out.println(list);
    }

}
