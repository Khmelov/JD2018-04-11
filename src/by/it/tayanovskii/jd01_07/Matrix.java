package by.it.tayanovskii.jd01_07;

class Matrix extends AbstractVar{
    private double [] [] value;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{");
        String delimiter="";

        for (int i = 0; i < value[0].length; i++) {
            sb.append("{");
            for (int j = 0; j < value.length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            sb.append("}");
        }
        sb.append('}');
        return sb.toString();

    }
}
