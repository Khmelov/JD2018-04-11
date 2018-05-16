package by.it.kashayed.jd01_10;


@Param(a=1,b=2)
public class Bean {

   // @Param(a=4, b=8)
    static double sum (int a, int b){
        return  a+b;
    }

    //@Param(a=1, b=2)
     double max (int a, int b){
        return a>b?a:b;
    }


    double min (int a, int b){
        return   a<b?a:b;
    }
   // @Param(a=31, b=22)
    static double avg (int a, int b){
        return  (a+b)/2.0;
    }

}
