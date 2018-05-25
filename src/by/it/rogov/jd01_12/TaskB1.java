package by.it.rogov.jd01_12;

import java.util.*;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        String s;
        List<String>  list = new ArrayList<>();

        while (!(s=scaner.next()).equals("end")){

                list.add(s.replaceAll("[^A-Za-z']","").trim());
                list.remove("");
            }

        for (String s1 : list) {
            System.out.println(s1 + "=" + Collections.frequency(list,s1));
        }




    }
}
