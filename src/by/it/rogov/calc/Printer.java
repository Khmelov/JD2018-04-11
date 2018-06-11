package by.it.rogov.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Printer {
    Logger log = Logger.getInstans();

    void print(Var var) {

        if (var != null) {
            log.toLog(var.toString());
            System.out.println(var);
        }
    }

    void print(Var var, String string) {
        if (var != null) {
            log.toLog(string + "=" + var.toString());
            System.out.println(string + "=" + var);
        }
    }

    static Map<String, Var> vars = new HashMap<>();
    static String filename = Path.path("vars.txt");

    static Var saveVar(String key, Var var) {
        vars.put(key, var);
        try (
                PrintWriter printWriter = new PrintWriter(
                        new FileWriter(filename))
        ) {
            for (Map.Entry<String, Var> stringVarEntry : vars.entrySet()) {

                printWriter.println(stringVarEntry.getKey() + "=" + stringVarEntry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return var;
    }


}
