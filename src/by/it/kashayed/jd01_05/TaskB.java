package by.it.kashayed.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        double y=0;
            for (double x = 1; x <=6; x++) {
              y+= -cos(x);
            }       

        for (double a = 0; a <= 2; a+=0.2) {
              double  t=y+6*pow(7,a);
            System.out.println(t);
        }
        double a=0;
        for (double x = -6; x<2 ; x+=0.5) {
            double q=x/2;
            if(-2<q&&q<=-1){
               a=log(abs(sin(pow(x,2))+2.74));
                System.out.println(a);

            }
            if(-1<q&&q<0.2){
                a=log(abs(cos(pow(x,2))+2.74));
                System.out.println(a);

            }
            if(q==0.2){
                a=log(abs(1.0/(tan(pow(x,2)))+2.74));
                System.out.println(a);

            }
            if(q>0.2||q<-2){
                System.out.println("вычисления не определены");

            }

        }

    }
}
