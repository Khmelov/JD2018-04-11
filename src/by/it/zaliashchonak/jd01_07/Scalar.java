package by.it.zaliashchonak.jd01_07;

/**
 * Created by Andrey on 04.05.2018.
 */
public class Scalar extends AbstractVar {

    private double value;
    Scalar(double value){
        this.value = value;
    }

    public Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    public Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }


    @Override
    public String toString(){
        return Double.toString(value);
    }
}

