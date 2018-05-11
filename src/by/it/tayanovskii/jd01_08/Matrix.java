package by.it.tayanovskii.jd01_08;

class Matrix extends Var {
    private double [] [] value;

    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder("{");
        String delimiter="";

        for (int i = 0; i < value[0].length; i++) {
            sb.append("{");
            for (int j = 0; j < value.length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter=",";
            }
            sb.append("}");
            delimiter="";

        }
        sb.append("}");
        return sb.toString().replaceAll("}\\{", "},{");

    }
    Matrix(double[ ][ ] value)
    {

        this.value  = new double[value[0].length][value.length];

        for (int i = 0; i < value[0].length; i++) {
            for (int j = 0; j < value.length; j++) {
               this.value[i][j]=value[i][j];
            }
        }

    }

    Matrix(String strMatrix)
    {

        String[] rowValues = strMatrix.trim().split("},\\{");

        for (int i = 0; i < rowValues.length; i++) {
            String[] strValues = rowValues[i].replaceAll("\\{|}", "").trim().split(",");
            if(value==null)
                value = new double[rowValues.length][strValues.length];
            for (int j = 0; j < strValues.length; j++) {
                value[i][j] = Double.parseDouble(strValues[j]);
            }
        }

    }

    Matrix(Matrix matrix)
    {
        this.value=matrix.value;
    }


}
