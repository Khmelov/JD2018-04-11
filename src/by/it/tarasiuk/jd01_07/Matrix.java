package by.it.tarasiuk.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value=value;
    }

    Matrix(Matrix matrix) {
        this.value=matrix.value;
    }

    Matrix(String strMatrix) {
        this.value=strToMat(strMatrix);
    }
//переделать метод, т.к. преобразавание в двумерный массив некорректно
    private double[][] strToMat(String str) {
        double[] mas={};
        int i=0;
        Pattern p = Pattern.compile("-?[\\d]+\\.?[\\d]*");
        Matcher m = p.matcher(str);
        while (m.find()) {
            mas=Arrays.copyOf(mas, i+1);
            mas[i]=Double.parseDouble(m.group());
            i++;
        }
        i=0;
        double[][] matrix=new double[2][mas.length/2];
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                matrix[j][k]=mas[i++];
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] val : value) {
            sb.append("{");
            for (double v : val) {
                sb.append(delimiter).append(v);
                delimiter = ", ";
            }
            sb.append("}, ");
            delimiter = "";
        }
        sb.delete(sb.length()-2, sb.length()).append("}");
        return sb.toString();
    }
}
