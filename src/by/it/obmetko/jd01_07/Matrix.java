package by.it.obmetko.jd01_07;

;


public class Matrix extends AbstractVar {
    private double value[][];;
    Matrix(Matrix mtrx) {
        this.value=mtrx.value;
    }
    Matrix(double[][] mtrxMas) {
        this.value=mtrxMas;
    }
    Matrix(String matrixString) {
        String s = matrixString.substring(1,matrixString.length()-1);
        String[] strMas = s.split("},");
        for (int i = 0; i <strMas.length ; i++) {
            if (i==strMas.length-1) strMas[i] = strMas[i].substring(1,strMas[i].length()-1);
            else
                strMas[i] = strMas[i].substring(1,strMas[i].length());

        }
        String[] rowNumber = strMas[0].split(",");
        value = new double[strMas.length][rowNumber.length];
        for (int i = 0; i < strMas.length; i++) {
            String[] s1 = strMas[i].split(",");
            for (int j = 0; j <s1.length ; j++) {
               value[i][j] = Double.parseDouble(s1[j]);
            }

        }


    }
    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i <value.length ; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                if (j==value[0].length-1) sb.append(value[i][j]);
                else {
                    sb.append(value[i][j]);
                    sb.append(",");

                }
            }
            sb.append("}");
            if(i<value.length-1) sb.append(",");
        }
        sb.append("}");

        return sb.toString();
    }


}