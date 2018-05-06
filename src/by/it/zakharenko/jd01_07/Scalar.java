package by.it.zakharenko.jd01_07;

class Scalar extends AbstractVar {

    private double value;

    Scalar(double value) {   //из вещественного числа
        this.value = value;
    }

    Scalar(Scalar otherScalar) {  //из такой же переменной
        this.value = otherScalar.value;
    }

    Scalar(String strValue) {    //из строки
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}

