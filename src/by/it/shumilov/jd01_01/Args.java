package by.it.shumilov.jd01_01;

public class Args {
    private String[] args;

    Args(String[] args) {
        this.args = args;
    }

    void printArgs() {
        int i = 1;
        for (String arg : args) {
            i++;
            System.out.println("Аргумент " + i + "=" + arg);
        }
    }
}
