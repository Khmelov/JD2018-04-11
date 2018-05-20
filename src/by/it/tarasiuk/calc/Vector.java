package by.it.tarasiuk.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    Vector(String strVector) {
        this.value = strToVec(strVector);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res=Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res=Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]*=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res=Arrays.copyOf(value, value.length);
            double sum=0;
            for (int i = 0; i < res.length; i++) {
                res[i]*=((Vector) other).value[i];
                sum+=res[i];
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]/=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else
            return super.div(other);
    }

    private double[] strToVec(String str) {
        double[] mas={};
        int i=0;
        Pattern p = Pattern.compile("-?[\\d]+\\.?[\\d]*");
        Matcher m = p.matcher(str);
        while (m.find()) {
            mas=Arrays.copyOf(mas, i+1);
            mas[i]=Double.parseDouble(m.group());
            i++;
        }
        return mas;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
