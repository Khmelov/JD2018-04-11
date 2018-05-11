package by.it.tayanovskii.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;





    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {

        this.value  = new double[otherMatrix.value.length][otherMatrix.value[0].length];
        for (int i = 0; i < otherMatrix.value.length; i++) {
            for (int j = 0; j < otherMatrix.value[i].length; j++) {
                this.value[i][j]=otherMatrix.value[i][j];
            }
        }


    }

    Matrix(String strMatrix)
    {

        String[] rowValues = strMatrix.trim().split("},\\{");

        for (int i = 0; i < rowValues.length; i++) {
            String[] strValues = rowValues[i].replaceAll("\\{|}", "").trim().split(",");
            if(value==null)
                value = new double[rowValues.length][strValues.length];
            for (int j = 0; j < strValues.length; j++) {
                value[i][j] = Double.parseDouble(strValues[j]);
            }
        }

    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[][] matrix = new double [this.value[0].length][this.value.length];
            double scalar=((Scalar)other).getValue();
            for (int i = 0; i < this.value[0].length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    matrix[i][j]=this.value[i][j]+scalar;
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Matrix) {
            double[][] matrix = new double [this.value[0].length][this.value.length];
            for (int i = 0; i < this.value[0].length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    matrix[i][j]=this.value[i][j] + ((Matrix) other).value[i][j];
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
            double[][] matrix = new double [this.value[0].length][this.value.length];
            double scalar=((Scalar)other).getValue();
            for (int i = 0; i < this.value[0].length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    matrix[i][j]=this.value[i][j]-scalar;
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Matrix) {
            double[][] matrix = new double [this.value[0].length][this.value.length];
            for (int i = 0; i < this.value[0].length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    matrix[i][j]=this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";

        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ",";
            }
            sb.append("}");
            delimiter = "";

        }
        sb.append("}");
        return sb.toString().replaceAll("}\\{", "},{");

    }



}
