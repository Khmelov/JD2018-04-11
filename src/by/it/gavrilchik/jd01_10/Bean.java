package by.it.gavrilchik.jd01_10;

public class Bean {
    @Param(a=3,b=7)
    double sum (int a, int b) {
        return a+b;
    }

    @Param(a=20, b=40)
    double min (int a, int b) {
        return a<b?a:b;

    }
    @Param(a=5, b=9)
    static double max (int a, int b) {
        return a>b?a:b;

    }
    static double avg (int a, int b) {
        return (a+b)/2.0;

    }
}
