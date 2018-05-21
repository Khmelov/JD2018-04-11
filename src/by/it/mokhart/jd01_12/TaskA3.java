package by.it.mokhart.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers with + and -, type \"end\" to end");
        ArrayList<Integer> ints = new ArrayList<>();
        String line;
        int pos = 0;
        while (!(line = scanner.nextLine()).equals("end")) {
            int value = Integer.parseInt(line);
            if (value > 0)
                ints.add(pos++, value);
            else if (value == 0)
                ints.add(pos, value);
            else
                ints.add(value);
        }
        System.out.println(ints);


    }
}
