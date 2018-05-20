package by.it.zakharenko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        int pos = 0;
        List<Integer> list = new ArrayList<>();
        while (!(s = scanner.next()).equals("end")) {
            int i = Integer.parseInt(s);  //parse для Integer
            if (i > 0)
                list.add(pos++, i);
            else if (i < 0)
                list.add(i);
            else
                list.add(pos, i);
        }
        System.out.println(list);
    }
}