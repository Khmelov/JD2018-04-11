package by.it.lanevich.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends AbstractVar {
    private double[] value;


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
