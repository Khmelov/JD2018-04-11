package by.it.dkruchek.jd01_07;

/**
 * Created by Dmitriy.Kruchek on 4/28/2018.
 */
public class Matrix extends AbstractVar{

    private double[][] value;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String elementDelimiter = "";
        String arrDelimiter = "";
        for (double[] arr : value) {
            sb.append(arrDelimiter).append("{");
            for (double element : arr) {
                sb.append(elementDelimiter).append(element);
                elementDelimiter = ", ";
            }
            sb.append("}");
            elementDelimiter = "";
            arrDelimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    public Matrix(String strMatrix){
        strMatrix = strMatrix.replaceAll("[{]+","")+"},";
        String rows[] = strMatrix.split("[}]+,");
        this.value = new double[rows.length][];
        String row[];
        for (int i = 0; i < rows.length; i++) {
            row = rows[i].split(",");
            this.value[i] = new double[row.length];
            for (int j = 0; j < row.length; j++) {
                this.value[i][j] = Double.parseDouble(row[j]);
            }
        }
    }

    public Matrix(double[][] arr){

        this.value = arr;
    }

    public Matrix(Matrix matrix){

        this.value = matrix.value;
    }

}
