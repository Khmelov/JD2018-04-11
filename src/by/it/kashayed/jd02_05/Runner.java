package by.it.kashayed.jd02_05;


import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        System.out.printf("%s\n%s\n%s: %s\n",manager.getString("msg1"),
                manager.getString("msg2"),
                manager.getString("msg3"),
                manager.getString("msg4"));
        manager.changeResource(new Locale("be","BY"));
        System.out.printf("%s\n%s\n%s: %s\n",manager.getString("msg1"),
                manager.getString("msg2"),
                manager.getString("msg3"),
                manager.getString("msg4"));
        manager.changeResource(new Locale("en","US"));
        System.out.printf("%s\n%s\n%s: %s\n",manager.getString("msg1"),
                manager.getString("msg2"),
                manager.getString("msg3"),
                manager.getString("msg4"));
    }
}
