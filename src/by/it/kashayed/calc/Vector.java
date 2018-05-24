package by.it.kashayed.calc;

public class Vector extends Var {

    @Override
    public Var add(Var other) throws CalcExeption{
        if(other instanceof Vector){
            if(((Vector) other).value!=this.value){
                throw new CalcExeption("размеры векторов не совпадают");
            }
            double add [] = new double [this.value.length];
            for (int i = 0; i < add.length; i++) {
                add[i] = this.value[i]+((Vector) other).value[i];
            }
            return new Vector(add);
        }
        else if(other instanceof Scalar){
            double [] p = new double[this.value.length];
            for (int i = 0; i < p.length; i++) {
                p[i]=this.value[i]+((Scalar)other).value;
            }
            return new Vector(p);        //как реализовать сложение на скаляр
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcExeption{
        if(other instanceof Vector){
            if(((Vector) other).value!=this.value){
                throw new CalcExeption("размеры векторов не совпадают");
            }
            double sub [] = new double [3];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = this.value[i]-((Vector) other).value[i];
            }
            return new Vector(sub);
        }
        else if(other instanceof Scalar){
            double [] p = new double[this.value.length];
            for (int i = 0; i < p.length; i++) {
                p[i]=this.value[i]-((Scalar)other).value;
            }
            return new Vector(p);
        }

        else return other.add(this);
    }

    @Override
    public Var mul(Var other) throws CalcExeption{
        if(other instanceof Vector){
            double sub = this.value[0]*((Vector) other).value[0]+
                    this.value[1]*((Vector) other).value[1]+this.value[2]*((Vector) other).value[2];
            return new Scalar(sub);
        }
        else if(other instanceof Scalar){
            double [] p = new double[this.value.length];
            for (int i = 0; i < p.length; i++) {
                p[i]=this.value[i]*((Scalar)other).value;
            }
            return new Vector(p);
        }
        else return other.add(this);
    }

    @Override
    public Var div(Var other) throws CalcExeption{
        if(other instanceof Scalar){
            if (((Scalar) other).value==0){
                throw new CalcExeption("деление вектора на 0");
            }
            double [] p = new double[this.value.length];
            for (int i = 0; i < p.length; i++) {
                p[i]=this.value[i]/((Scalar)other).value;
            }
            return new Vector(p);
        }
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
