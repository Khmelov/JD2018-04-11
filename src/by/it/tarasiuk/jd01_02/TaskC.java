package by.it.tarasiuk.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] ars) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas=TaskC.step1(n);
        step1(n);
        printer(mas);
        step2(mas);
        step3(mas);
        printer(TaskC.step3(mas));
    }

    private static int[][] step1(int n) {
        boolean max, min;
        int[][] mas=new int[n][n];
        do {
            max = min = false;
            for (int i=0;i<mas.length;i++){
                for (int j=0;j<mas.length;j++){
                    mas[i][j] = (-n +(int)(Math.random()*(2*n + 1)));
                }
            }
            for (int[] t: mas ){
                for(int i: t){
                    if (i == n) max = true;
                    if (i == -n) min = true;
                }
            }
        }while (!min || !max);
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int p1=-1;
            int p2=-1;
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j] > 0) {
                    if(p1==-1) p1 = j;
                    else if(p2<j) p2=j;
                }
            }
            if (p1>=0 && p2>(p1+1)){
                for (int j = p1+1; j < p2; j++) sum+=mas[i][j];
            }
        }
        System.out.println(sum);
        return sum;
    }


    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        int r=0;
        int c=0;
        int masDel[][];
        boolean delRow[] = new boolean[mas.length];
        boolean delCol[] = new boolean[mas.length];

        for (int[] i : mas) {
            for (int j : i) {
                if (max < j) max = j;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    delRow[i] = delCol[j] = true;
                }
            }
        }

        for (boolean i:delRow ) if (!i) r++;
        for (boolean j:delCol) if (!j) c++;

        masDel = new int[r][c];
        int k=0;
        for (int i = 0; i < r; i++) {
            int l =0;
            for (int j = 0; j < c; j++) {
                stop: for (; k < delRow.length; k++) {
                        if (delRow[k]) continue;
                        for (; l < delCol.length; l++) {
                            if (delCol[l]) continue;
                            masDel[i][j] = mas[k][l++];
                            break stop;
                        }
                }
            }
            k++;
        }

    return masDel;
    }

    private static void printer(int[][] mas){
            for (int[] t : mas) {
                for (int i : t) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
    }

}
