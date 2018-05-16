package by.it.gavrilchik.jd01_09;

public class Vector extends Var {

    private double[] value;


    Vector(String strVector) {
        String[] strValues = strVector
                .replaceAll("\\{|}", "")
                .trim()
                .split(",\\s*");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strValues[i]);

        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";

        }
sb.append(')');
        return sb.toString();
    }
}

