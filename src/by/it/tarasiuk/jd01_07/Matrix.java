package by.it.tarasiuk.jd01_07;


class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value=value;
    }

    Matrix(Matrix matrix) {
        this.value=matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix=strMatrix.replaceAll("[{]+","")+"},";
        String[] lines=strMatrix.split("[}]+,");
        this.value=new double[lines.length][];
        String[] line;
        for (int i = 0; i < lines.length; i++) {
            line=lines[i].split(",");
            this.value[i]=new double[line.length];
            for (int j = 0; j < line.length; j++) {
                this.value[i][j]=Double.parseDouble(line[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] val : value) {
            sb.append("{");
            for (double v : val) {
                sb.append(delimiter).append(v);
                delimiter = ", ";
            }
            sb.append("}, ");
            delimiter = "";
        }
        sb.delete(sb.length()-2, sb.length()).append("}");
        return sb.toString();
    }
}
