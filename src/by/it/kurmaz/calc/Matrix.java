package by.it.kurmaz.calc;

public class Matrix extends Var {
    private double[][] value;

    public Matrix (double[][] value) {
        this.value = value;
    }

    public Matrix (Matrix matrix) {
        this.value = matrix.getValue();
    }

    public Matrix (String strMatrix) {

        String[] array = strMatrix.replaceAll("\\{\\{|}}", "").trim().split("},\\s?\\{");

        String[] line = array[0].trim().split(",\\s?");
        value = new double[array.length][line.length];
        for (int i = 0; i < array.length; i++) {
            String[] row = array[i].trim().split(",\\s?");
            for (int j = 0; j < row.length; j++) {
                value[i][j] = Double.parseDouble(row[j]);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Matrix) {
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException(ConsoleRunner.resMan.getString("msg.sizeError"));
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Matrix) {
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException(ConsoleRunner.resMan.getString("msg.sizeError"));
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Matrix){
            if ((this.value.length != ((Matrix) other).value[0].length))
                throw new CalcException(ConsoleRunner.resMan.getString("msg.sizeError"));
            double[][] newMatrix = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        newMatrix[i][j] += this.value[i][k]* ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(newMatrix);
        }
        else if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Vector) {
            if (this.value[0].length != ((Vector) other).getValue().length)
                throw new CalcException(ConsoleRunner.resMan.getString("msg.sizeError"));
            double[] newMatrix = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++ ) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    newMatrix[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(newMatrix);
        }
        else
            return super.mul(other);
    }


    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar){
            if (((Scalar) other).getValue() == 0)
                throw new CalcException(ConsoleRunner.resMan.getString("msg.divideByZero"));
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.div(other);
    }

    public String toString () {
        StringBuilder line = new StringBuilder();
        line.append('{');
        for (int i = 0; i < value.length; i++) {
            line.append('{');
            String space = "";
            for (int j = 0; j < value[i].length; j++) {
                line.append(space);
                line.append(value[i][j]);
                space = ", ";
            }
            line.append('}');
            if (i < value.length - 1)
                line.append(space);
        }

        line.append('}');
        return line.toString();
    }

    public double[][] getValue() {
        return value;
    }
}
