package by.it.shumilov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {
        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher ;

        try (BufferedReader br = new BufferedReader(new FileReader(path("text.txt")))){

            while (br.ready()){
                String line = br.readLine();
                matcher = pat.matcher(line);
                while (matcher.find()){
                    System.out.println(matcher.group());
                }

                /*
                String[] ty = line.split("[а-яА-ЯёЁ]+");
                for (String s : ty) {
                    System.out.println(s);
                }*/

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private  static  String path(Class<?> cl){
        String rootPrj = System.getProperty("user.dir") ;
        String path = cl.getName().replaceAll(cl.getSimpleName(),"").replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator +"src" + File.separator + path;
        return  path;
    }

    private static  String path(String fileName){
        return  path(TaskB.class) + fileName;
    }
}
