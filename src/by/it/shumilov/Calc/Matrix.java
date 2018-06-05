package by.it.shumilov.Calc;

class Matrix extends Var {

    private  double[][] value;



    public double[][] getValue() {

        return getDouble(value);
    }
    private  double[][] getDouble(double[][] inDouble){
        double[][] res = new double[inDouble.length][inDouble[0].length];
        for (int i = 0; i < inDouble.length; i++) {
            for (int j = 0; j < inDouble[0].length; j++) {
                res[i][j] = inDouble[i][j];
            }
        }
        return res;
    }

    Matrix(Vector vector){
        double[] vec = vector.getValue();
        this.value = new double[vec.length][1];
        for (int i = 0; i < vec.length; i++) {
            this.value[i][0] = vec[i];
        }

    }

    Matrix(String strValue){
        String[] strCols = strValue.split("(\\}\\,\\p{Blank}*\\{)");
        int s = strCols[0].replaceAll("[{|}|p{Blank}*]","").split(",").length;
        value = new  double[strCols.length][strCols[0]
                                        .replaceAll("[{|}|p{Blank}*]","").split(",").length];
        for (int i = 0; i < strCols.length; i++) {
            String[] strRows = strCols[i].replaceAll("[{|}|p{Blank}*]","").split(",");
            for (int j = 0; j < strRows.length; j++) {
                value[i][j] = Double.parseDouble(strRows[j]);
            }

        }
    }

    Matrix(double[][] value){
        this.value = getDouble(value);
    }

    Matrix(Matrix objMatrix){
        this.value = objMatrix.getValue();

    }


    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar) {
            double scalar = ((Scalar)other). getValue();
            double[][] res = this.getValue();
            for (double[] re : res) {
                for (int i = 0; i < re.length; i++) {
                    re[i] += scalar;
                }
            }
            return new Matrix(res);
        }

        else if(other instanceof Matrix){
            if((this.value.length == ((Matrix) other).value.length) && (this.value[0].length == ((Matrix) other).value[0].length)){
                double[][] res = this.getValue();

                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j]+=((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
            else
                return super.add(other);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){

            double scalar = ((Scalar)other). getValue();
            double[][] res = this.getValue();
            for (double[] re : res) {
                for (int i = 0; i < re.length; i++) {
                    re[i] -= scalar;
                }
            }

            return new Matrix(res);
        }
        else
            try {
                return this.add(other.mul(new Scalar(-1)));
            }
            catch (CalcException e){
                throw new CalcException("Операция вычитания " + this.toString()+ ", " + other.toString() + " невозможна");
            }
    }

    @Override
    public Var mul(Var other) throws CalcException {

        if(other instanceof Scalar) {
            double scalar = ((Scalar)other). getValue();
            double[][] res = this.getValue();
            for (double[] re : res) {
                for (int i = 0; i < re.length; i++) {
                    re[i] *= scalar;
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector){

            return new Vector((Matrix)this.mul(new Matrix((Vector) other)));
        }
        else if (other instanceof Matrix){
            if (this.value[0].length == ((Matrix) other).value.length){

            double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
            double sum;
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    sum = 0;
                    for (int k = 0; k < this.value[0].length; k++) {
                        sum += this.value[i][k]*((Matrix) other).value[k][j];
                    }
                    res[i][j] = sum;
                }
            }
            return new Matrix(res);
            }
            else
                throw new CalcException("Операция умножения невозможна: нет соответствя условию равности количества столбцов"+
                        this.toString() + " количеству cтрок " + other.toString());
        }
        return super.add(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar) {
            double scalar = ((Scalar)other). getValue();
            double[][] res = this.getValue();
            if (scalar==0)

                throw new CalcException("Деление на ноль");
            for (double[] re : res) {
                for (int i = 0; i < re.length; i++) {
                    re[i] /= scalar;
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

        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            String delmeter = "";
            for (double v : value[i]) {
                sb.append(delmeter).append(v);
                delmeter = ",";
            }
            sb.append("},");
        }
        int del = sb.lastIndexOf(",");
        sb.delete(del, del+2);

        sb.append("}");
        return sb.toString();
    }
}
