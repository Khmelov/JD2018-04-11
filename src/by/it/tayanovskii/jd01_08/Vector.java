package by.it.tayanovskii.jd01_08;

class Vector extends Var {
    private double [] value;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter="";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append('}');
        return sb.toString();
    }

    Vector (String strVector)
    {
        String[] strValues = strVector.replaceAll("\\{|}", "").trim().split(",\\s*");
        value=new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }

    }

    Vector(double[ ] value)
    {
        this.value=new double[value.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i]=value[i];
        }
    }

    Vector (Vector otherVector)
    {
        this.value = otherVector.value;
    }


}
