package by.it.kashayed.jd01_08;

public class Vector extends Var {

    @Override
    public Var add(Var other) {
        if(other instanceof Vector){
            double add [] = new double [this.value.length];
            for (int i = 0; i < add.length; i++) {
                 add[i] = this.value[i]+((Vector) other).value[i];
            }
            return new Vector(add);
        }

//                    else if(other instanceof Scalar){
//                        double [] p = new double[this.value.length];
//            for (int i = 0; i < p.length; i++) {
//                p[i]=this.value[i]+4;
//            }
//                        return new Vector(p);        //как реализовать сложение на скаляр
//
//                    }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Vector){
            double sub [] = new double [3];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = this.value[i]-((Vector) other).value[i];
            }
            return new Vector(sub);
        }

        else return other.add(this);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Vector){
               double sub = this.value[0]*((Vector) other).value[0]+
                       this.value[1]*((Vector) other).value[1]+this.value[2]*((Vector) other).value[2];
            return new Scalar(sub);
        }
        else return other.add(this);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    private double [] value;
    Vector(double[] value){
        this.value=value;
    }
    Vector(Vector vector){
        this.value=vector.value;
    }
    Vector(String strVector){
        String[] strValues = strVector
                .replaceAll("\\{|}", "")
                .trim()
                .split(",\\s*");
        value=new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("{");
        String delimetr = "";
        for (double v : value) {
            stringBuilder.append(delimetr).append(v);
            delimetr=", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
