package by.it.krivenkova.jd01_07;

public class Vector {
    private double[]  value;

    Vector(String strVector){
        String[] strValues = strVector
                .replaceAll("\\{[]","")
                .trim()
                .split(",\\s*");
        value = new double[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            value[i] = Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value){
     //      sb.append(delimiter)
        }
    }
}
