package by.it.krivenkova.jd01_04;

 class Helper {
    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return Double.MIN_VALUE;
        }
        else {
            double elMin = arr[0];
            for (double el : arr) {
                if (elMin > el) elMin = el;
            }
            return elMin;
        }
    }

    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return Double.MAX_VALUE;
        } else {
            double elMax = arr[0];
            for (double el : arr) {
                if (elMax < el) elMax = el;
            }
            return elMax;
        }
    }

    static void sort(double[] arr) {

        for (int i = 0; i < arr.length; i++) {        /*Предполагаем, что первый элемент (в каждом
                                                          подмножестве элементов) является минимальным */
            double min = arr[i];
            int min_i = i;
                                                        /*В оставшейся части подмножества ищем элемент,
                                                        который меньше предположенного минимума*/
            for (int j = i + 1; j < arr.length; j++) {
                                                        //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
                                                      /*Если нашелся элемент, меньший, чем на текущей позиции,
                                                            меняем их местами*/
            if (i != min_i) {
                double tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }


    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] = res[i] + matrix[i][j] * vector[j];
            }
        }
        return  res;
    }
 static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
double[][] res = new  double[matrixLeft.length][matrixRight[0].length];
     for (int i = 0; i < matrixLeft.length; i++) {
         for (int j = 0; j < matrixRight[0].length; j++) {
             for (int k = 0; k < matrixRight.length; k++) {
                 res[i][j] = res[i][j] + matrixLeft[i][k]*matrixRight[k][j];
             }
         }
     }
return res;
 }



}
