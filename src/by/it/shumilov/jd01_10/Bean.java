package by.it.shumilov.jd01_10;

public class Bean {

    @Param(a=3, b=7)
    double sum(int a, int b){
        return a+b;
    }

    @Param(a=2, b=8)
    double max(int a, int b){
        return (a>b) ? a : b;
    }

    @Param(a=9, b=2)
    static double min(int a, int b){
        return (a<b) ? a : b;
    }

    static double avg(int a, int b){
        return (a + b) / 2.0;
    }
}
