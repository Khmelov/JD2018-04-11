package by.it.kasiyanov.jd02_02;

public class Printer {

    static final Object printMonitor = new Object();

    static void printLine(String line){
        synchronized (printMonitor){
            System.out.println(line);
        }
    }

    static void lineBreak(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    static void cashierPrint(int cashierNumber, String line){
        for (int i = 1; i < cashierNumber; i++) {
            System.out.print("                    |");
        }
        System.out.printf("%-19s" + "|", line);
        for (int i = cashierNumber; i < 7; i++) {
            System.out.print("                    |");
        }
        System.out.println();
    }

    static void cashierLastLine(int buyerQueue, Double sales){
        for (int i = 1; i < 6; i++) {
            System.out.print("                    |");
        }
        System.out.printf("%-20d" + "|" + "%-20.1f" + "|" + "\n", buyerQueue, sales);
    }
}
