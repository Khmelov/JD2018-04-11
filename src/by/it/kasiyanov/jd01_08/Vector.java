package by.it.kasiyanov.jd01_08;

class Vector extends AbstractVar {
    private double [] value;

    Vector(double[] value){
        this.value = value;
    }

    Vector (Vector vector){
        this.value = vector.value;
    }

    Vector (String str){
        str = str.replace("{", " ").replace("}"," ").trim();
        str = str.replace(","," ");
        String strArr[] = str.split(" ");

        double[] tmp = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            tmp [i] = Double.parseDouble(strArr[i]);
        }
        this.value = tmp;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");

        return sb.toString();
    }
}
