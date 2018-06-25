package by.it.tarasiuk.jd03_01;

import java.util.Scanner;

class Runner {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Type:\n1 - to initialize database;\n" +
                "2 - to reset database;\n" +
                "3 - to exit.");
        String line = scanner.nextLine();
        switch (line) {
            case "1":
                C_Init.db_init();
                break;
            case "2":
                C_Reset.db_reset();
                break;
            case "3":
                break;
            default:
                System.out.println("Incorrect command!");
        }
    }
}
