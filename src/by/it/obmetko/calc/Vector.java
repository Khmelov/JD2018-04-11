package by.it.obmetko.calc;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String str) {
        String s = str.substring(1,str.length()-1);
        String[] strMas = s.split(",");
        this.value = new double[strMas.length];
        for (int i = 0; i <strMas.length ; i++) {
            value[i] = Double.parseDouble(strMas[i]);
        }

    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (this.value.length==((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];
                }
                return new Vector(res);
            }
            else throw new CalcException("Вектора разной длины");
        }
        else
            return super.add(other);
    }
    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (this.value.length==((Vector) other).value.length) {
                double[] res=Arrays.copyOf(value,value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]=res[i]-((Vector)other).value[i];
                }
                return new Vector(res);
            }
            else throw new CalcException("Нельзя вычитать вектора разной длины");
        }
        else
            return super.sub(other);
    }
    @Override
    public Var mul(Var other)  throws CalcException{
        if (other instanceof Scalar){
            double[] vector=Arrays.copyOf(this.value,this.value.length);
            double scalar=((Scalar)other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i]*=scalar;
            }
            return new Vector(vector);
        }
        else if (other instanceof Vector) {
            double scalar=0;
            Vector otherVector = (Vector) other;
            if (this.value.length!=otherVector.value.length)
                throw new CalcException("Разные размеры векторов "+this+"*"+otherVector);
            for (int i = 0; i < this.value.length; i++) {
                scalar+=this.value[i]*otherVector.value[i];
            }
            return new Scalar(scalar);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other)  throws CalcException{
        if (other instanceof Scalar){
            double[] vector=Arrays.copyOf(this.value,this.value.length);
            double scalar=((Scalar)other).getValue();
            if (scalar==0)
                throw new CalcException("Деление на ноль: "+this+"/"+scalar);
            for (int i = 0; i < vector.length; i++) {
                vector[i]/=scalar;
            }
            return new Vector(vector);
        }
        else
            return super.div(other);
    }
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}

