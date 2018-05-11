package by.it.mokhart.jd01_07;

public class Matrix extends AbstractVar {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }
    Matrix(String strMatrix){
        String[] strValues = strMatrix
                .replaceAll("\\{\\{|\\}\\}", "")
                .trim()
                .split("\\},\\s?\\{");//?
        String[] strValues1 = strValues[0]
                .trim()
                .split(",\\s?");
        value = new double[strValues.length][strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            String[] matrix = strValues[i]
                    .trim()
                    .split(",\\s?");
            for (int j = 0; j < strValues.length; j++) {
                value[i][j] = Double.parseDouble(matrix[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        String delimetr = "{";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                builder.append(delimetr).append(value[i][j]);
                delimetr = ", ";
            }
            delimetr = ", {";
            builder.append("}");
        }
        builder.append("}");
        return builder.toString();
    }
}
