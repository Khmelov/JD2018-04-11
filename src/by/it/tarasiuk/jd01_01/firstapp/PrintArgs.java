package by.it.tarasiuk.jd01_01.firstapp;

public class PrintArgs {

    private String[] args;

    public PrintArgs(String[] args) {
        this.args = args;
    }
    void printArgs() {
        int i = 0;
        for (String arg : args) {
              i++;
            System.out.println("Аргумент " + i + " = " + arg);

        }
    }
}
