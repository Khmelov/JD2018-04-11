package by.it.shumilov.Calc;

import java.util.Arrays;

class Vector extends Var {

    private GetStr getStr = GetStr.getInstance();

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(Matrix matrix){
        double[][] res =  matrix.getValue();
        this.value = new double[res.length];
        for (int i = 0; i < res.length; i++) {
            this.value[i] = res[i][0];
        }
    }

    Vector(double[] value){

        this.value = value;
    }

    Vector(Vector objVector){

        this.value = Arrays.copyOf(objVector.value,
                objVector.value.length
        );
    }

    Vector(String strVector){

        String[] strVal=strVector.replaceAll("[{|}]", "")
                .trim().split(",\\s*");
        value = new  double[strVal.length];

        for (int i = 0; i < strVal.length; i++) {
            value[i] = Double.parseDouble(strVal[i]);

        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof  Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar)other). getValue();
            for (int i = 0; i < res.length; i++) {
                res[i]+=scalar;
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(String.format("%s %s %s: %s %s %s",getStr.getString(Message.OP),
                        getStr.getString(Op.ADD),
                        getStr.getString(Err.IMP),
                        getStr.getString(Message.DIFVECT),
                        this.value,
                        getStr.getString(Message.AND),
                        ((Vector) other).value));
            double[] res = Arrays.copyOf(this.value, this.value.length);

            for (int i = 0; i < res.length; i++) {
                res[i]+=((Vector)other).value[i];
            }
            return new Vector(res);
        }

        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {


        if(other instanceof  Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar)other). getValue();
            for (int i = 0; i < res.length; i++) {
                res[i]-=scalar;
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(String.format("%s %s %s: %s %s %s",getStr.getString(Message.OP),
                        getStr.getString(Op.SUB),
                        getStr.getString(Err.IMP),
                        getStr.getString(Message.DIFVECT),
                        this.value,
                        getStr.getString(Message.AND),
                        ((Vector) other).value));

            double[] res = Arrays.copyOf(this.value, this.value.length);

            for (int i = 0; i < res.length; i++) {
                res[i]-=((Vector)other).value[i];
            }
            return new Vector(res);
        }

        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {

        if(other instanceof  Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar)other). getValue();
            for (int i = 0; i < res.length; i++) {
                res[i]*=scalar;
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            if(this.value.length == ((Vector) other).value.length){
                double[] res = Arrays.copyOf(this.value, this.value.length);
                double answ = 0;
                for (int i = 0; i < res.length; i++) {
                    answ += res[i]*((Vector)other).value[i];
                }
                return new Scalar(answ);
            }
            else
                return super.mul(other);
        }

        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {

        if(other instanceof  Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar)other). getValue();
            if (scalar==0)

                throw new CalcException(getStr.getString(Err.DIVZERO));
            for (int i = 0; i < res.length; i++) {
                res[i]/=scalar;
            }
            return new Vector(res);
        }

        else
            return super.div(other);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delmeter = "";
        for (double v : value) {
            sb.append(delmeter).append(v);
            delmeter = ",";
        }
        sb.append("}");
        return  sb.toString();
    }
}
