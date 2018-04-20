package by.it.dkruchek.jd01_02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 4/15/2018.
 */
public class TaskC {

    private static int[][] step1(int n){
        int[][] matrix = new int[n][n];
        boolean containsN = false;
        boolean containsMinusN = false;
        Random random = new Random();
        while (!(containsN && containsMinusN)) {
            containsN = false;
            containsMinusN = false;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    int number = random.nextInt(11) -n;
                    if (number == n) containsN = true;
                    if (number == -n) containsMinusN = true;
                    matrix[j][i] = number;
                }
            }
        }
        for (int[] arr: matrix) {
            for (int i: arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    static int step2(int[][] mas){
        int sum = 0;
        for (int[] arr : mas) {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > 0){
                    for (int j = i + 1; j < arr.length; j++){
                        if (arr[j] < 0) {
                            sum = sum + arr[j];
                        }
                        else break;
                    }
                    break;
                }
            }  
        }
        return sum;
    }

    static int[][] step3(int[][] mas){

        // find max value
        int maxElement = mas[0][0];
        for (int[] arr : mas) {
            for (int element: arr) {
                if (element > maxElement){
                    maxElement = element;
                }
            }
        }
        int rowCount = mas.length;
        int colCount = mas[0].length;

        ArrayList<Integer> rowsForDeletion = new ArrayList<>();
        ArrayList<Integer> colsForDeletion = new ArrayList<>();

        // identify rows with max value
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                if (mas[i][j] == maxElement) {
                    rowsForDeletion.add(i);
                    break;
                }
            }
        }
        // identify columns with max value
        for(int j = 0; j < colCount; j++){
            for(int i = 0; i < rowCount; i++)
                if (mas[i][j] == maxElement) {
                    colsForDeletion.add(j);
                    break;
                }
        }
        // intitiate new matrix
        int[][] masNew = new int[rowCount-rowsForDeletion.size()][colCount-colsForDeletion.size()];

        int newRows = 0;

        for(int i = 0; i < rowCount; i++){
            int newCols = 0;
            if (!rowsForDeletion.contains(i))    {
                for (int j = 0; j < colCount; j++) {
                    if (!colsForDeletion.contains(j)) {
                        masNew[newRows][newCols] = mas[i][j];
                        newCols++;
                    }
                }
                newRows++;
            }
        }
        return masNew;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
    }
}
