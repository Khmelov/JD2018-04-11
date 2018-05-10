package by.it.kasiyanov.jd01_07;


class Matrix extends AbstractVar {
    private double[][] value;

    Matrix (double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix (String str){

        String arr[] = str.split("},");
        double [][] res = new double [arr.length][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("{", " ").replace("}"," ").trim();
            String tmp[] = arr[i].split(",");
            res [i] = new double[tmp.length];
            for (int j = 0; j < tmp.length; j++) {
                res[i][j] = Double.parseDouble(tmp[j]);
            }
        }
        this.value = res;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        String arrdelimetr = "";

        for (int i = 0; i < value.length; i++) {
            sb.append(arrdelimetr).append("{");
            delimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ",";
            }
            sb.append("}");
            arrdelimetr = ", ";
        }
        sb.append("}");

        return sb.toString();
    }
}
