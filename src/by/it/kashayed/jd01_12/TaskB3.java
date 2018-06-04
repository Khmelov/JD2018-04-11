package by.it.kashayed.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;

public class TaskB3 {
    public static class Timer{
        private  long iniTime;
        private  Double Delta;
        public Timer(){
            iniTime=System.nanoTime();
        }
        public  String toString(){
            Delta=(double)(System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();

            return "Прошло "+Delta.toString()+" микросекунд.";
        }

    }
    static String process(ArrayList<String> peoples){
        Timer timer = new Timer();
        ArrayList<String> a = new ArrayList<>(peoples);
        for (int i = 0; i < a.size()-1; i++) {
            a.remove(i+1);
            a.add(a.get(i));
        }
        while(a.size()!=1){
            a.remove(0);
        }
        System.out.println(a);
        System.out.println(timer);
        return a.get(0);
    }

    static String process(LinkedList<String> peoples){
        Timer timer = new Timer();
        ArrayList<String> a = new ArrayList<>(peoples);
        for (int i = 0; i < a.size()-1; i++) {
            a.remove(i+1);
            a.add(a.get(i));
        }
        while(a.size()!=1){
            a.remove(0);
        }

        System.out.println(a);
        System.out.println(timer);
        return a.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scaner =new Scanner(System.in);
        int n=scaner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(i, "people"+(i+1));
        }
        System.out.println(list);
        LinkedList<String> lilist = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lilist.add(i, "people"+(i+1));
        }
        System.out.println(lilist);
        process(list);
        process(lilist);

    }
}
