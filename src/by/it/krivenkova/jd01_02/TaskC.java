package by.it.krivenkova.jd01_02;

import java.util.*;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 'n': ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        matrix = step1(n);
        System.out.println("Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        int sum = step2(matrix);
        System.out.println("sum:  " + sum);


        int[][] m = {
                {1, 2, 3, 4, 5},
                {6, 7, 6, 7, 0},
                {1, 7, 2, 3, 4},
                {0, 0, 0, 0, 0}
        };
        step3(m);//atrix);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean flagUp, flagLow;
        int upN = n;
        int lowN = -n;

        //     System.out.println("upN:  " + upN + "  lowN:  " + lowN);
        do {
            flagLow = false;
            flagUp = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * ((n * 2) + 1)) - n;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] == upN) {
                        //                   System.out.println("mas[i][j]:  " + mas[i][j] + "  upN:  " + upN);
                        flagUp = true;
                    }
                    if (mas[i][j] == lowN) {
                        //                  System.out.println("mas[i][j]:  " + mas[i][j] + "  lowN:  " + lowN);
                        flagLow = true;
                    }
                }
            }

        } while ((flagUp == false) || (flagLow == false));
        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        int sumBetweenEl, firstEl, secondEl, jFir, jSec;
        for (int i = 0; i < mas.length; i++) {
            sumBetweenEl = 0;
            firstEl = 0;
            jFir = 0;
            secondEl = 0;
            jSec = 0;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0 && firstEl == 0) {
                    firstEl = mas[i][j];
                    jFir = j;
                } else {
                    if (mas[i][j] > 0 && secondEl == 0) {
                        secondEl = mas[i][j];
                        jSec = j;
                        for (int k = jFir + 1; k < jSec; k++) {
                            sumBetweenEl += mas[i][k];
                        }
                        sum += sumBetweenEl;
                    }
                }
            }
        }
        return sum;
    }

   /* static int[][] step3(int[][] mas) {
        System.out.println("Max  " + mas.length);
        int max = mas.length;
       ArrayList<Integer> iStr = new ArrayList<Integer>();
        ArrayList<Integer>  jStr = new ArrayList<Integer>();
        boolean flag = false;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    iStr.add(i);
                    jStr.add(j);
                    flag = true;
                }
            }
        }
        ArrayList<Integer> iStrSpec = new ArrayList<Integer>();
        ArrayList<Integer>  jStrSpec = new ArrayList<Integer>();
        iStrSpec = iStr;
        jStrSpec = jStr;

        Collections.sort(iStrSpec);
        Collections.sort(jStrSpec);
        Set<Integer> hs = new HashSet<>();
        hs.addAll(iStrSpec);
        iStrSpec.clear();
        iStrSpec.addAll(hs);

        hs.clear();
        hs.addAll(jStrSpec);
        jStrSpec.clear();
        jStrSpec.addAll(hs);

        int sizeNewj = max-jStrSpec.size();
        int sizeNewi = max-iStrSpec.size();
        System.out.println();
        System.out.println("i  "+sizeNewi + " j "+ sizeNewj);

         int[][] newMas = new int[sizeNewi][sizeNewj];
int k = 0;
           for (int i = 0; i < mas.length; i++) {
               if (i != iStr.get(k)) {
                   for (int j = 0; j < mas.length; j++) {
                       if (j != jStr.get(i)) {
                           for (int iN = 0; iN < newMas.length; iN++) {
                               for (int jN = 0; jN < newMas.length; jN++) {
                                   newMas[iN][jN] = mas[i][j];
                               }
                           }
                       }
                   }
               }
           }

           System.out.println("New Matrix");
           for (int i = 0; i < newMas.length; i++) {
               for (int j = 0; j < newMas.length; j++) {
                   System.out.print(newMas[i][j] + " ");
               }
               System.out.print("\n");
           }
        return mas;
    }*/

    static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int[] row : mas) {
            for (int element : row) {
                if (element > max) max = element;
            }
        }

        boolean[] delCol = new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delRow[i] = true;
                    delCol[i] = true;
                }

            }
        }

        int rr=0, cc=0;
        for (boolean b : delCol) {
            if (!b) rr++;
        }
        for (boolean b : delRow) {
            if (!b) cc++;
        }

        int[][] m= new int[rr][cc];

        int ii=0, jj=0;
        for (int i = 0; i < mas.length; i++) {
            jj = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if (!delCol[j] && !delRow[j]) {
                    m[ii][jj] = mas[i][j];
                    jj++;
                }
            }
            if (!delRow[i]) ii++;
        }


                return m;
    }
}
