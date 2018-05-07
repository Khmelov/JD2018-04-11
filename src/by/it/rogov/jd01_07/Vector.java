package by.it.rogov.jd01_07;

import java.util.Arrays;

class Vector extends AbstractVar {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String[] array = strVector
                .replace('{', ' ')
                .replace('}', ' ').trim().split(",");
        value = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            value[i] = Double.parseDouble(array[i]);

        }
    }


    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}
