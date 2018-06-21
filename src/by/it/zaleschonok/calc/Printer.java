package by.it.zaleschonok.calc;

public class Printer {

    private static Printer instance;


    private Printer() {
    }

    public static Printer getInstance(){
        if(instance == null){
            instance = new Printer();
        }
        return instance;
    }

    void print(Var var) {
        if (var != null)
            System.out.println(var);
    }


}
