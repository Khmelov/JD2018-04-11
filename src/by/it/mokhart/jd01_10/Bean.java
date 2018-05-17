package by.it.mokhart.jd01_10;

public class Bean {
    @Param(a = 3, b = 5)
    static double sum(int x, int y) {
        return x + y;
    }

    @Param(a = 3, b = 4)
    static double max(int x, int y) {
        if (x > y)
            return x;
        else
            return y;
    }

    @Param(a = 3, b = 3)
    double min(int x, int y) {
        if (x < y)
            return x;
        else
            return y;
    }

    double avg(int x, int y) {
        return (x + y) / 2.0;
    }
}
