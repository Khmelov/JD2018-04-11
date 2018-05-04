package by.it.kasiyanov.jd01_07;

import java.util.Arrays;

class Matrix extends AbstractVar {
    private double[][] value;

    Matrix (double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        String arrdelimetr = "";

        for (int i = 0; i < value.length; i++) {
            sb.append(arrdelimetr).append("{");
            delimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ",";
            }
            sb.append("}");
            arrdelimetr = ", ";
        }
        sb.append("}");

        return sb.toString();


    }
}
