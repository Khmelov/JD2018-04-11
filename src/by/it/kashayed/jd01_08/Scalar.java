package by.it.kashayed.jd01_08;

public class Scalar extends Var {
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value+((Scalar) other).value;
            return new Scalar(sum);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double sub = this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
        else return new Scalar(-1).mul(other).add(this) ;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double div = this.value/((Scalar) other).value;
            return new Scalar(div);
        }
        else return super.add(this);
    }

    public double value;

    Scalar (double value){
        this.value=value;
    }
    Scalar (Scalar otherScalar){
        this.value=otherScalar.value;
    }
    Scalar (String strValue){
        this.value=Double.parseDouble(strValue);
    }
    @Override
    public String toString() {
        return Double.toString(value);//"Это скаляр";
    }

}
