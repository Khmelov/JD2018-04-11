package by.it.tayanovskii.jd01_08;


public class Matrix extends Var {

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


        String[] arrayValues = strMatrix.replaceAll("\\{\\{|}}", "").trim().split("},\\s?\\{");

        String[] row = arrayValues[0].trim().split(",\\s?");
        value = new double[arrayValues.length][row.length];
        for (int i = 0; i < arrayValues.length; i++) {
            String[] strValues = arrayValues[i].trim().split(",\\s?");
            for (int j = 0; j < row.length; j++) {
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
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            double scalar=((Scalar)other).getValue();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] * scalar;
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Vector) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++ ) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    result[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector (result);
        }

        else if (other instanceof Matrix){

            double[][] result = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        result[i][j] += this.value[i][k]* ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[][] resultMatrix = new double[this.value.length][this.value[0].length];
            double scalar=((Scalar)other).getValue();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    resultMatrix[i][j] = this.value[i][j] / scalar;
                }
            }
            return new Matrix(resultMatrix);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");


        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            String delimiter = "";
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
            if (i < value.length - 1)
                sb.append( delimiter);

        }
        sb.append("}");
        return sb.toString();

    }

}
