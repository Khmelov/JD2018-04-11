package by.it.rogov.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Log {

    String filename = Path.path("log.txt");
    static List<String> logList= new ArrayList<>();

    void toLog(String message){
        try(PrintWriter printWriter=new PrintWriter(new FileWriter(filename))){
            logList.add(message);
            for (String s : logList) {
                printWriter.println(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
