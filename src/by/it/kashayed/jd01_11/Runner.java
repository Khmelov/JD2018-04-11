package by.it.kashayed.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        List<String> arlist = new ArrayList<>();
        list.add("Firsl"); arlist.add("Firsl");
        list.add("Second"); arlist.add("Second");
        list.add("Third"); arlist.add("Third");
        list.add("Throth"); arlist.add("Throth");
        list.add("Fifth"); arlist.add("Fifth");
        System.out.println(list);
        System.out.println(arlist);
        list.remove(3); arlist.remove(3);
        list.remove(2); arlist.remove(2);
        System.out.println(list);
        System.out.println(arlist);
    }
}
