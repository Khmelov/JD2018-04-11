package by.it.krivenkova.calc;

public class CreatorScalar extends Creator {
    @Override
    public Scalar factoryMethod() {
        return new Scalar(12);
    }
}
