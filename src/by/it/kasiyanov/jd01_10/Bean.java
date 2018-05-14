package by.it.kasiyanov.jd01_10;

public class Bean {
    @Param(a = 2, b = 3)
    static double sum(int a, int b){
        return a + b;
    }
    @Param(a = 4, b = 9)
    static double min(int a, int b){
        return a < b ? a : b;
    }
    @Param(a = 7, b = 1)
    double max(int a, int b){
        return a > b ? a : b;
    }
    double avg(int a, int b){
        return (a + b) / 2.0;
    }
}
