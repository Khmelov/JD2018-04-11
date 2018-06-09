package by.it.lanevich.calc2;

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
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            strVector = matcher.replaceAll("");
        }
        String[] str = strVector.split(",");
        double[] v = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            v[i] = Double.parseDouble(str[i]);
        }
        this.value = v;
    }

    @Override
    public Var add(Var other) throws CalcException {
        //сложение вектора со скаляром
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else
            //сложение вектор с вектором
            if (other instanceof Vector) {
                if (((Vector) other).value.length!=this.value.length)
                    throw new CalcException("Не совпадают размеры векторов");
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];
                }
                return new Vector(res);
            }
            else
                //сложение вектора с матрицей
                return super.add(other);

    }

    @Override
    public Var sub(Var other)throws CalcException {
        //вычитание из вектора скаляра
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else
            //вычитание из вектора вектора
            if (other instanceof Vector) {
                if (((Vector) other).value.length!=this.value.length)
                    throw new CalcException("Не совпадают размеры векторов");
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] - ((Vector) other).value[i];
                }
                return new Vector(res);
            }
            else
                //вычитание из вектора матрицы
                return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        //умножение вектора на скаляр
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else
            //умножение вектора на вектор
            if (other instanceof Vector) {
                double res = 0;
                for (int i = 0; i < value.length; i++) {
                    res = res + ((Vector) other).value[i] * this.value[i];
                }
                return new Scalar(res);
            }
            else
                //умножение вектора на матрицу
                return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        //деление вектора на скаляр
        if (other instanceof Scalar) {
            if(((Scalar)other).getValue()==0)
                throw new CalcException("Деление на ноль");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else
            //деление вектора на вектор и вектора на матрицу
            return super.div(other);
    }

    @Override
    public String toString() {
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