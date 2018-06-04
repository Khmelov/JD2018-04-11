package by.it.kurmaz.jd02_03;

class Printer {

    static final Integer monitor = 0;

    static void printLine(int tabs, String line) {
        System.out.print("|");
        for (int i = 0; i < tabs; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("\t");
            }
            System.out.print("|");
        }
        System.out.printf("%-15s", line);
        System.out.print("|");
        for (int i = 0; i < (7 - tabs); i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("\t");
            }
            System.out.print("|");
        }
        System.out.println();
    }
}
