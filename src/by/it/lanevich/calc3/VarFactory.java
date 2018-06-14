package by.it.lanevich.calc3;

public class VarFactory {
    static abstract class Creator {
        public abstract Var parse(String s) throws CalcException;
    }

    static class CreatorScalar extends Creator {
        @Override
        public Var parse(String s) { return new Scalar(s); }
    }

    static class CreatorVector extends Creator {
        @Override
        public Var parse(String s) { return new Vector(s); }
    }

    static class CreatorMatrix extends Creator {
        @Override
        public Var parse(String s) throws CalcException { return new Matrix(s); }
    }
}
