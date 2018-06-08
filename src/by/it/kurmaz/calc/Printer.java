package by.it.kurmaz.calc;

public class Printer {

    private static Printer instance;

    private Printer() {}

    static Printer getInstance() {
        if (instance == null)
            instance = new Printer();
        return instance;
    }

    void resultPrint(String result) {
        System.out.println(ConsoleRunner.resMan.getString("msg.result") + result);
        System.out.println(ConsoleRunner.resMan.getString("msg.proceed"));
    }

    void varPrint() {
        System.out.println(ConsoleRunner.resMan.getString("msg.proceed"));
    }
}
