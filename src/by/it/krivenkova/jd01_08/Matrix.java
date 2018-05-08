package by.it.krivenkova.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {
    private double value[][];

    Matrix(double [][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        strMatrix = strMatrix.replaceAll("[{]+","")+"},";
        String lines[] = strMatrix.split("[}]+,");
        value = new double[lines.length][];
        String line[];
        for (int i = 0; i < lines.length; i++) {
            line = lines[i].split(",");
            value[i] = new double[line.length];
            for (int j = 0; j < line.length; j++) {
                value[i][j] = Double.parseDouble(line[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double matrix[][] = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double scalar = ((Scalar)other).getValue();
            for (double[] el:matrix)
            for (int i = 0; i < matrix.length; i++) {
                el[i]+=scalar;
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Matrix) {
            double matrix[][] = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j]+=((Matrix)other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double matrix[][] = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double scalar = ((Scalar)other).getValue();
            for (double[] el:matrix)
                for (int i = 0; i < matrix.length; i++) {
                    el[i]-=scalar;
                }
            return new Matrix(matrix);
        }
        else if (other instanceof Matrix) {
            double matrix[][] = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j]-=((Matrix)other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double matrix[][] = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double scalar = ((Scalar)other).getValue();
            for (double[] el:matrix)
                for (int i = 0; i < matrix.length; i++) {
                    el[i]*=scalar;
                }
            return new Matrix(matrix);
        }
        else if (other instanceof Matrix) {
            double matrix[][] = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j]*=((Matrix)other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double matrix[][] = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double scalar = ((Scalar)other).getValue();
            for (double[] el:matrix)
                for (int i = 0; i < matrix.length; i++) {
                    el[i]/=scalar;
                }
            return new Matrix(matrix);
        }
           return super.div(other);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if ((value[i].length - 1) > j) delimiter = ", ";
                else delimiter = "}, {";
            }
        }
            sb.append("}}");
            return sb.toString();

    }
}
