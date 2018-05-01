package by.it.sharin.jd01_07;

class Vector extends AbstractVar {
    private double[] value;

    Vector(double[] value) {
        this.value=value;
    }

    Vector(String str) {
        str=str.substring(1,6);
        String[] strArr=str.split(",");
        double[] value=new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            value[i]=Double.parseDouble(strArr[i]);
        }
        this.value=value;
    }

    Vector(Vector vector) {
        this.value=vector.value;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
