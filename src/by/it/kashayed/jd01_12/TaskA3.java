package by.it.kashayed.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
                                                    //  String st = scanner.next();
        String s;
        int a=0;
        List<Integer> list = new ArrayList<>();
        while(!(s=scanner.next()).equals("end")){     //почему нельзя написать while(!st.equals("end"))
            Integer i = Integer.valueOf(s);
            if(i<0)list.add(i);
            else if (i>0)list.add(a++,i);
            else if (i==0)list.add(a,0);
        }
        System.out.println(list);
    }
}
