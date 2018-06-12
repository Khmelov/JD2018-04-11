package by.it.krivenkova.calc;

public class CreatorVector extends Creator{
    @Override
    public Var factoryMethod() {
        return new Vector("3,8,1");
    }
}
