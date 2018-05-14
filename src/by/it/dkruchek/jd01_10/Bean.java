package by.it.dkruchek.jd01_10;

/**
 * Created by Dmitriy.Kruchek on 5/11/2018.
 */
public class Bean {

    @Param(a=1, b=2)
    public static double sum(int a, int b){
        return a + b;
    }
    @Param(a=2, b=3)
    public double max(int a, int b){
        return a > b ? a : b;
    }
    @Param(a=3, b=4)
    public double min(int a, int b){
        return a < b ? a : b;
    }

    public static double avg(int a, int b){
        return (a + b) / 2.0;
    }
}
