package by.it.tarasiuk.calc;


import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value=value;
    }

    Matrix(Matrix matrix) {
        this.value=matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix=strMatrix.replaceAll("[{]+","")+"},";
        String[] lines=strMatrix.split("[}]+,");
        this.value=new double[lines.length][];
        String[] line;
        for (int i = 0; i < lines.length; i++) {
            line=lines[i].split(",");
            this.value[i]=new double[line.length];
            for (int j = 0; j < line.length; j++) {
                this.value[i][j]=Double.parseDouble(line[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res=new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] res=new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]+=((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res=new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] res=new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]-=((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res=new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector) {
            double[] res=new double[value.length];
            double[][] matrix=new double[value.length][];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <matrix[i].length; j++) {
                    res[i]+= matrix[i][j]*((Vector) other).getValue()[j];
                }
            }
            return new Vector(res);
        }
        else if (other instanceof Matrix) {
            double[][] res=new double[value.length][((Matrix) other).value[0].length];
            double[][] matrix=new double[value.length][];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    for (int k = 0; k < res[i].length ; k++) {
                        res[i][j]+=value[i][k]*((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] res=new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] /= ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else
            return super.div(other);
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
