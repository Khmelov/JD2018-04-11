package by.it.krivenkova.jd01_07;

public class Matrix extends AbstractVar{
    private double value[][];

    Matrix(double [][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        strMatrix = strMatrix.replaceAll("[{]+","")+"},";
        String lines[] = strMatrix.split("[}]+,");
        value = new double[lines.length][];
        String line[];
        for (int i = 0; i < lines.length; i++) {
            line = lines[i].split(",");
            value[i] = new double[line.length];
            for (int j = 0; j < line.length; j++) {
                value[i][j] = Double.parseDouble(line[j]);
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
                if ((value[i].length - 1) > j) delimiter = ", ";
                else delimiter = "},{";
            }
        }
            sb.append("}}");
            return sb.toString();

    }
}
