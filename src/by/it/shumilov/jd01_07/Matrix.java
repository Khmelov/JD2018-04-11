package by.it.shumilov.jd01_07;

class Matrix extends AbstractVar {

    private  double[][] value;

    Matrix(String strValue){
        String[] strCols = strValue.split("(\\}\\,\\p{Blank}*\\{)");
        int s = strCols[0].replaceAll("[{|}|p{Blank}*]","").split(",").length;
        value = new  double[strCols.length][strCols[0]
                                        .replaceAll("[{|}|p{Blank}*]","").split(",").length];
        for (int i = 0; i < strCols.length; i++) {
            String[] strRows = strCols[i].replaceAll("[{|}|p{Blank}*]","").split(",");
            for (int j = 0; j < strRows.length; j++) {
                value[i][j] = Double.parseDouble(strRows[j]);
            }

        }
    }

    Matrix(double[][] value){
        this.value = value;
    }

    Matrix(Matrix objMatrix){
        this.value = objMatrix.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            String delmeter = "";
            for (double v : value[i]) {
                sb.append(delmeter).append(v);
                delmeter = ", ";
            }
            sb.append("}, ");
        }
        int del = sb.lastIndexOf(",");
        sb.delete(del, del+2);

        sb.append("}");
        return sb.toString();
    }
}
