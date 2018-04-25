package by.it.akhmelev.jd01_07;

class Scalar extends AbstractVar {

    private double value;

//    public void scalarPubMeth(){
//        System.out.println("scalarPubMeth");
//    }

    Scalar(double value){
        this.value=value;
    }

    Scalar(Scalar otherScalar){
        this.value=otherScalar.value;
    }

    Scalar(String strValue){
        this.value=Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
