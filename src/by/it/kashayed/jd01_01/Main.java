package by.it.kashayed.jd01_01;

public class Main {

    public static void main(String[] args) {
        int s = 0;
        for(int i = 1; i <= 10; i++)
        {
            s = s + i + 2;
            if(i % 9 == 0)
            {
                break;
            }
        }
        System.out.println(s);
    }
}
