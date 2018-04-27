package by.it.zakharenko.jd01_02;/*package by.it.zakharenko.jd01_02;

public class TaskC {

    int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int[] row : mas)
            for (int element : row)
                if (element > max) max = element;
                boolean[] delCol = new boolean[mas[0].length];
                boolean[] delRow = new boolean[mas.length];
                //заполним маркеры удаления
                for (int i = 0; i < mas.length; i++) {
                    for (int j = 0; j < mas[i].length; j++) {
                        if (mas[i][j] == max) {
                            delRow[i] = true;
                            delCol[j] = true;
                        }
                    }
                }


            //вычисляем размер массива
        int rr=0, cc=0;
                for(boolean b : delRow) if(!b) rr++;
                for(boolean b : delCol) if(!b) cc++;
                int[][] n= new int[rr][cc];


           //заполним ответ
           int ii=0, jj=0;
        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if(!delCol[i] && !delRow[j]){
                    delRow[i] = true;
                    delCol[j] = true;


                }

            }

        }
        }







    public static void main(String[] args) {
        int[][] n = {
                {1, 2, 3, 4, 5},
                {6, 7, 6, 7, 0},
                {1, 7, 2, 3, 4},
                {0, 0, 0, 0, 0}
        };
        int[][] z = step3(n);
    }
}
*/