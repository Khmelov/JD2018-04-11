package by.it.zakharenko.jd01_08;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {  //из массива
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {  //из такой же переменной
        this.value = otherMatrix.value;
    }

    Matrix(String strMatrix) {  //из строки
        String[] strValues = strMatrix
                .replaceAll("\\{\\{|\\}\\}", "")
                .trim()
                .split("\\},\\s?\\{");
        String[] strValues1 = strValues[0]
                .trim()
                .split(",\\s*");
        value = new double[strValues.length][strValues1.length];
        for (int i = 0; i < strValues.length; i++) {
            String[] mas = strValues[i]
                    .trim()
                    .split(",\\s?");
            for (int j = 0; j < strValues1.length; j++) {
                value[i][j] = Double.parseDouble(mas[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if ((value[i].length - 1) > j)
                    delimiter = ", ";
                else delimiter = "}, {";

            }
        }
        sb.append("}}");
        return sb.toString();
    }

}

