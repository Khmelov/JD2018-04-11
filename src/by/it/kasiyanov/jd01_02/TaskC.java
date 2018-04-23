package by.it.kasiyanov.jd01_02;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int mas[][] = step1(n);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        int sum = step2(mas);

        int newMas[][] = step3(mas);

        for (int a = 0; a < newMas.length; a++) {
            for (int b = 0; b < newMas[a].length; b++) {
                System.out.print(newMas[a][b] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] step1(int n) {
        int mas[][] = new int[n][n];
        boolean cont = true;
        while(cont){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = (int)(Math.random() * (2 * n + 1)) - n;
            }
        }
            boolean containN = false;
            boolean containMinN = false;
            for (int a = 0; a < mas.length; a++) {
                for (int b = 0; b < mas[a].length; b++) {
                    if (mas[a][b] == n){
                        containN = true;
                    }
                    else if (mas[a][b] == -n){
                        containMinN = true;
                    }
                }
            }
        if(containN && containMinN){
            cont = false;
        }
        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int start = 0;
        int finish = 0;

        int sum = 0;

        for (int i = 0; i < mas.length; i++) {
            int count = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if(mas[i][j] >= 0 && count == 0) {
                    start = j;
                    count = count + 1;
                }
                else if(mas[i][j] >= 0 && count == 1){
                    finish = j;
                    count = count + 1;
                    if(start < (finish - 1)) {
                        for (int a = (start + 1); a < finish; a++) {
                            sum = sum + mas[i][a];
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (max < mas[i][j]){
                    max = mas[i][j];
                }
            }
        }

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        for (int a = 0; a < mas.length; a++) {
            for (int b = 0; b < mas[a].length; b++) {
                if (max == mas[a][b]){
                    if(rows.contains(a)) {
                    }
                    else {
                        rows.add(a);
                    }
                    if(columns.contains(b)){
                    }
                    else {
                        columns.add(b);
                    }
                }
            }
        }

        int newMas[][] = new int[(mas.length-rows.size())][(mas[0].length-columns.size())];
        int c = 0;
        int r = 0;
        for (int row = 0; row < mas.length; row++) {
            for (int column = 0; column < mas[row].length; column++) {
                if(rows.contains(row)) {
                }
                else if (columns.contains(column)){
                }
                else {
                    newMas[r][c] = mas[row][column];
                    c++;
                }
            }
            if(c > 0){
                r++;
                c = 0;
            }
        }
        return newMas;
    }
}
