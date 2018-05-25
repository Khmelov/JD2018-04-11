package by.it.kashayed.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {


    private static String str (Class <?> cls){
        String name = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String path = cls.getName().replace(cls.getSimpleName(),"").replace(".",File.separator);
        return name+path;
    }
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Pattern p2 =Pattern.compile("[^а-яА-ЯёЁ]+");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(str(TaskB.class)+"text.txt")))
        {
    while (bufferedReader.ready()){
        String s = bufferedReader.readLine();
        System.out.println(s);

        Matcher matcher = p1.matcher(s);
        Matcher m2 = p2.matcher(s);
        while(matcher.find())
            stringBuilder.append(matcher.group()).append(" ");



    }
            System.out.println(stringBuilder);
//            System.out.println(stringBuilder);
//            Matcher matcher = p1.matcher(stringBuilder);
//            while (matcher.find()){
//                System.out.println(matcher.group());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
