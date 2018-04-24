package by.it.shumilov.jd01_02;


import java.util.Scanner;

public class TaskA {

public static void main (String[] args) {


Scanner scan=new Scanner(System.in);

int[] mas = new int[10];

    for (int i = 0; i < 10; i++) {
        mas[i] = scan.nextInt();
    }
    
    step1(mas);
    step2(mas);
    step3(mas);
}

    private static void step1(int[] mas) {
    int min = mas[0];
    int max = mas[0];
        for (int ma : mas) {
            if (ma > max)  max = ma;
            if (ma < min)  min = ma;
        }
        System.out.println(String.valueOf(min) + " " + String.valueOf(max));
    }

    private static void step2(int[] mas) {
    double sr = 0;
        for (int ma : mas) {
            sr += ma;
        }
        sr = sr / mas.length;
        for (int ma : mas) {
            if(ma < sr) System.out.print(String.valueOf(ma) + " ");
        }
    }

    private static void step3(int[] mas) {
        int min = mas[0];

        for (int ma : mas) {

            if (ma < min)  min = ma;
        }
        for (int i = mas.length - 1; i >=  0; i--) {

            if(mas[i] == min) System.out.print(String.valueOf(i) + " ");
        }
    }


}


