package by.it.dkruchek.jd01_07;

/**
 * Created by Dmitriy.Kruchek on 4/25/2018.
 */
public class Vector extends AbstractVar{

    private double[] value;

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

    public Vector(String strVector) {
        String[] values = strVector.replaceAll("[{}]", "")
                                    .trim()
                                    .split(",\\s*");
        value = new double[values.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(values[i]);
        }
    }

    public Vector(double[] array){

        this.value = array;
    }

    public Vector(Vector vector){

        this.value = vector.value;
    }

}
