package by.it.kashayed.jd01_07;

import java.util.Arrays;

class Vector extends AbstractVar{
    private double [] value;

    Vector(double[] value){
        this.value=value;
    }

    Vector(Vector vector){
        this.value=vector.value;
    }
    Vector(String strVector){
        String[] strValues = strVector
                .replaceAll("\\{|}", "")
                .trim()
                .split(",\\s*");
        value=new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }
//    Vector(String strVector) {
//        String [] vec = strVector.trim().split(", ");
//        double [] got = new double[vec.length];
//        for (int i = 0; i < got.length; i++) {
//            got[i]=Double.parseDouble(vec[i]);
//        }
//        this.value=got;
//
//    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("{");
        String delimetr = "";
        for (double v : value) {
            stringBuilder.append(delimetr).append(v);
            delimetr=", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
