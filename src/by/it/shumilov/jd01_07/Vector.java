package by.it.shumilov.jd01_07;

class Vector extends  AbstractVar {

    private double[] value;

    Vector(double[] value){
        this.value = value.clone();
    }

    Vector(Vector objVector){

        this.value = new  double[objVector.value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = objVector.value[i];
        }
    }

    Vector(String strVector){

        String[] strVal=strVector.replaceAll("[{|}]", "")
                .trim().split(",\\s*");
        value = new  double[strVal.length];

        for (int i = 0; i < strVal.length; i++) {
            value[i] = Double.parseDouble(strVal[i]);

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delmeter = "";
        for (double v : value) {
            sb.append(delmeter).append(v);
            delmeter = ", ";
        }
        sb.append("}");
        return  sb.toString();
    }
}
