package by.it.kurmaz.calc;

public class Printer {
    void resultPrint(String result) {
        System.out.println("Result is: " + result);
        System.out.println("Type a new expression, or type \"end\" to exit");
    }

    void varPrint() {
        System.out.println("Type new variable, or type \"printvar\\sortvar\" to see variables. Type \"end\" to exit");
    }
}
