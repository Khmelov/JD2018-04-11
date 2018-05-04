package by.it.kurmaz.jd01_08;

public class Vector extends Var {
    private double[] value;

    public Vector (double[] value) {
        this.value = value;
    }
    public Vector (Vector vector) {
        this.value = vector.getValue();
    }

    public Vector (String strVector) {
        String[] array = strVector.replaceAll("[{}]", "").trim().split(",");
        value = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            value[i] = Double.parseDouble(array[i]);
        }
    }

    public double[] getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append('{');
        for (double v: value) {
            line.append(String.valueOf(v));
            line.append(", ");
        }
        line.deleteCharAt(line.length() - 1);
        line.deleteCharAt(line.length() - 1);
        line.append('}');
        return line.toString();
    }

}
