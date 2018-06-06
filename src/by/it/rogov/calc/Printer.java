package by.it.rogov.calc;

public class Printer {
    Log log = new Log();
    void print(Var var) {

        if (var != null) {
            log.toLog(var.toString());
            System.out.println(var);
        }
    }

    void print(Var var,String string){
        if (var!=null){
            log.toLog(string+"="+var.toString());
            System.out.println(string+"="+var);
        }
    }



}
