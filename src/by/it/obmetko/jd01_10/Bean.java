package by.it.obmetko.jd01_10;

import org.junit.runners.Parameterized;

public class Bean {
    @Param(a = 3, b = 6)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 9)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
    @Param(a = 7, b = 16)
    static double min(int a, int b) {
        return a<b ? a : b;
    }
    static double max(int a, int b) {
        return a>b ? a : b;
    }
}

