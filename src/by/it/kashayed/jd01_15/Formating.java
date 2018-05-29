package by.it.kashayed.jd01_15;

import java.io.PrintStream;

public class Formating {

    static String formating(String text, PrintStream printStream){
        if (!text.equals("")){
            if(text.contains("/")) {
                if (text.contains("//")){
                    String cut = text.substring(text.indexOf("//"),text.length());
                    String newstring =text.replace(cut,"");
                    System.out.println(newstring);
                    printStream.println(newstring);
                }
                else if(text.contains("/*")){
                    String cut = text.substring(text.indexOf("/*"),text.length());
                    String newstring =text.replace(cut,"");
                    System.out.println(newstring);
                    printStream.println(newstring);
                }
                else if(text.contains("*/")){
                    String cut = text.substring(0,text.indexOf("*/")+2);
                    String newstring =text.replace(cut,"");
                    System.out.println(newstring);
                    printStream.println(newstring);
                }
            }
            else if (text.indexOf("*")==1){
                String cut = text;
                String newstring =text.replace(cut,"");
                System.out.println(newstring);
                printStream.println(newstring);
            }
            else {
                System.out.println(text);
                printStream.println(text);
            }


        }
        else {
            System.out.println(text);
            printStream.println(text);
        }
        return "Complite";
    }
}
