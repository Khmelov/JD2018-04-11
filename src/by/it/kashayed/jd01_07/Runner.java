package by.it.kashayed.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar abstractVar = new Scalar(3.1415);
        System.out.println(abstractVar);
        AbstractVar as = new Vector("1, 555 , 4.0");
        System.out.println(as);
    }
}
