package by.it.kurmaz.jd01_08;

public class Matrix extends Var {
    private double[][] value;

    public Matrix (double[][] value) {
        this.value = value;
    }

    public Matrix (Matrix matrix) {
        this.value = matrix.getValue();
    }

    public Matrix (String strMatrix) {
        String[] array = strMatrix.replaceAll("\\{\\{|\\}\\}", "").trim().split("\\},\\s?\\{");
        String[] line = array[0].trim().split(",\\s?");
        value = new double[array.length][line.length];
        for (int i = 0; i < array.length; i++) {
            String[] row = array[i].trim().split(",\\s?");
            for (int j = 0; j < row.length; j++) {
                value[i][j] = Double.parseDouble(row[j]);
            }
        }
    }

    public String toString () {
        StringBuilder line = new StringBuilder();
        line.append('{');
        for (int i = 0; i < value.length; i++) {
            line.append('{');
            String space = "";
            for (int j = 0; j < value[i].length; j++) {
                line.append(space);
                line.append(value[i][j]);
                space = ", ";
            }
            line.append('}');
            if (i < value.length - 1)
                line.append(space);
        }

        line.append('}');
        return line.toString();
    }

    public double[][] getValue() {
        return value;
    }
}
