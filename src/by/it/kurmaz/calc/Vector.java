package by.it.kurmaz.calc;

public class Vector extends Var {
    private double[] value;

    public Vector (double[] value) {
        this.value = value;
    }
    public Vector (Vector vector) {
        this.value = vector.getValue();
    }

    public Vector (String strVector) {
        String[] array = strVector.replaceAll("[{}]", "").trim().split(",");
        value = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            value[i] = Double.parseDouble(array[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(ConsoleRunner.resMan.getString("msg.sizeError"));
            double[] vector = new double[this.value.length];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = this.value[i] + ((Vector) other).value[i];
            }
            return new Vector(vector);
        }
        else if (other instanceof Scalar) {
            double[] vector = new double[this.value.length];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = this.value[i] + ((Scalar) other).getValue();
            }
            return new Vector(vector);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(ConsoleRunner.resMan.getString("msg.sizeError"));
            double[] vector = new double[this.value.length];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(vector);
        }
        else if (other instanceof Scalar) {
            double[] vector = new double[this.value.length];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = this.value[i] - ((Scalar) other).getValue();
            }
            return new Vector(vector);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(ConsoleRunner.resMan.getString("msg.sizeError"));
            double sum = 0;
            for (int i = 0; i < this.value.length; i++) {
                sum += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);
        }
        else if (other instanceof Scalar) {
            double[] vector = new double[this.value.length];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return new Vector(vector);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0)
                throw new CalcException(ConsoleRunner.resMan.getString("msg.divideByZero"));
            double[] vector = new double[this.value.length];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(vector);
        }
        else
            return super.div(other);
    }


    public double[] getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append('{');
        for (double v: value) {
            line.append(String.valueOf(v));
            line.append(", ");
        }
        line.deleteCharAt(line.length() - 1);
        line.deleteCharAt(line.length() - 1);
        line.append('}');
        return line.toString();
    }

}
