package by.it.akhmelev.jd01_10;

public class Bean {

    @Param(a=3,b=7)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a=30,b=3)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a=20,b=40)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Override
    public String toString() {
        return "Bean{}";
    }
}
