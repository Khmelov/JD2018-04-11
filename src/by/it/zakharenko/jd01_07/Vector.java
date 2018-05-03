package by.it.zakharenko.jd01_07;

class Vector extends AbstractVar {

    private double[] value;

    Vector(double[] value) {  //из массива
        this.value = value;
    }

    Vector(Vector otherVector) {  //из такой же переменной
        this.value = otherVector.value;
    }

    Vector(String strVector) {  //из строки
        String[] strValues = strVector
                .replaceAll("[{|}]", "")
                .trim()
                .split(",\\s*");
        value = new double[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
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
        sb.append("}");
        return sb.toString();
    }
}

