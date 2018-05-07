package by.it.tayanovskii.jd01_07;

public class Scalar extends  AbstractVar
{
    private double value;

    Scalar(double value)
    {
        this.value=value;
    }

    Scalar(Scalar otherScalar)
    {
        this.value=otherScalar.value;
    }

    Scalar(String strValue)
    {
        this.value=Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
