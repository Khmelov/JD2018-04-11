package by.it.tarasiuk.jd01_07;

import java.util.Arrays;
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
        this.value = strToVec(strVector);
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
