package by.it.kurmaz.calc;

public class Printer {
    void resultPrint(String result) {
        System.out.println(ConsoleRunner.resMan.getString("msg.result") + result);
        System.out.println(ConsoleRunner.resMan.getString("msg.proceed"));
    }

    void varPrint() {
        System.out.println(ConsoleRunner.resMan.getString("msg.proceed"));
    }
}
