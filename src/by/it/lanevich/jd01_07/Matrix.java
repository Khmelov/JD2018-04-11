package by.it.lanevich.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends AbstractVar {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        //strMatrix={{1.0,2.0},{3.0,4.0}}
        Pattern pattern = Pattern.compile("[{}]{2,}");
        Matcher matcher = pattern.matcher(strMatrix);
        while (matcher.find()) {
            strMatrix = matcher.replaceAll("");
        }
        //strMatrix=1.0,2.0},{3.0,4.0
        String[] s = strMatrix.split("},\\{");

        //s[0]=1.0,2.0
        //s[1]=3.0,4.0
        double[][] m = new double[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            String[] str = s[i].split(",");
            for (int j = 0; j < str.length; j++) {
                m[i][j] = Double.parseDouble(str[j]);
            }
        }
        this.value = m;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {

                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
            delimiter = ",{";
        }
        sb.append("}");
        return sb.toString();
    }
}
