package by.it.kurmaz.jd01_10;

public class Bean {
    public static double sum (int a, int b) {
        return a+b;
    }
    @Param(a=2, b=4)
    public static double avg (int a, int b) {
        return (a+b)/2.0;
    }
    @Param(a=1, b=5)
    public double max (int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    @Param(a=3, b=6)
    public double min (int a, int b) {
        if (a > b)
            return b;
        return a;
    }
}
