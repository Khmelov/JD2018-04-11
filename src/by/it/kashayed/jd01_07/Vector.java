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
        String [] mas = strVector.split("[, ]+");
        double []masf=new double[mas.length];
        for (int i = 0; i < mas.length; i++) {
            masf[i]=Double.valueOf(mas[i]);
        }
        this.value=masf;

    }

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
