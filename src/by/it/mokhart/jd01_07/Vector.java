package by.it.mokhart.jd01_07;

import java.util.Arrays;

public class Vector extends AbstractVar {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector){
      String[] strValues = strVector
              .replaceAll("[{|}]","")
              .trim()
              .split(",\\s*");
      value = new double[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        String delimetr = "";
        for (double v : value) {
            builder.append(delimetr).append(v);
            delimetr = ", ";
        }
        builder.append("}");
        return builder.toString();
    }
}
