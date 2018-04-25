package by.it.kashayed.jd01_07;

class Scalar extends AbstractVar{
    private double value;

    Scalar (double value){
        this.value=value;
    }
    Scalar (Scalar otherScalar){
        this.value=otherScalar.value;
    }
    Scalar (String strValue){
        this.value=Double.parseDouble(strValue);
    }

}
