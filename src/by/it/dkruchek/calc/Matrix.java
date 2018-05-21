package by.it.dkruchek.calc;

import java.util.Arrays;

/**
 * Created by Dmitriy.Kruchek on 4/28/2018.
 */
public class Matrix extends Var {

    private double[][] value;

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

    @Override
    public Var add(Var other)  throws CalcException{
        if (other instanceof Scalar){
            double matrix[][]= new double [this.value.length][];
            for (int i = 0; i < this.value.length; i++)
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[i].length; i1++) {
                    matrix[i][i1] += scalar;
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Matrix){
            if (this.value.length != ((Matrix) other).value.length || this.value[0].length != ((Matrix) other).value[0].length){
                throw new CalcException("Martrices are not the same size");
            }
            double matrix[][]= new double [this.value.length][];
            for (int i = 0; i < this.value.length; i++)
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[i].length; i1++) {
                    matrix[i][i1] += ((Matrix) other).getValue()[i][i1];
                }
            }
            return new Matrix(matrix);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        if (other instanceof Scalar){
            return this.add(other.mul(new Scalar(-1)));
        }
        else if (other instanceof Matrix){
            if (this.value.length != ((Matrix) other).value.length || this.value[0].length != ((Matrix) other).value[0].length){
                throw new CalcException("Martrices are not the same size");
            }
            return this.add(other.mul(new Scalar(-1)));
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar){
            double matrix[][]= new double [this.value.length][];
            for (int i = 0; i < this.value.length; i++)
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[i].length; i1++) {
                    matrix[i][i1] *= scalar;
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Vector) {
            double result[] = new double[((Vector) other).getValue().length];
                for (int i = 0; i < this.value.length; i++)
                    for (int j = 0; j < result.length; j++)
                        result[i] += (this.value[i][j] * ((Vector) other).getValue()[j]);
            return new Vector(result);
        }
        else if (other instanceof Matrix){
            if (this.value.length != ((Matrix) other).value.length || this.value[0].length != ((Matrix) other).value[0].length){
                throw new CalcException("Martrices are not the same size");
            }
            double matrix[][] = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++)
                    for (int k = 0; k < matrix[i].length; k++)
                        matrix[i][j] += (this.value[i][k] * ((Matrix) other).value[k][j]);

            return new Matrix(matrix);
        }
        return super.mul(other);
    }

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

    public double[][] getValue() {
        return value;
    }
}
