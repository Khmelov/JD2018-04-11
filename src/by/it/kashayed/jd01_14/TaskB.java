package by.it.kashayed.jd01_14;

import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {


    private static String str(Class<?> cls) {
        String name = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cls.getName().replace(cls.getSimpleName(), "").replace(".", File.separator);
        return name + path;
    }

    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Pattern p2 = Pattern.compile("[-?,.:!]+");
//      StringBuilder sb2 = new StringBuilder();
//       Map<String,Integer> map = new HashMap<>();
        int cwords = 0;
        int count = 0;
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader(str(TaskB.class) + "text.txt"));
             PrintWriter prw =new PrintWriter(str(TaskB.class)+"resultTaskB.txt")
        )
         {
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
//                      System.out.println(s);
                Matcher m1 = p1.matcher(s);

                Matcher m2 = p2.matcher(s);
                while (m1.find()) {
                    String word = m1.group();
                    cwords++;
                }
                while (m2.find()) {
                    count++;
                }
//                                sb2.append(word).append(" ");
//                                if (map.containsKey(word))
//                                    map.put(word,map.get(word)+1);
//                                    else map.put(word,1);
            }
//                  System.out.println(sb2);
//            System.out.println(map);
            System.out.println("words=" + cwords);
            prw.println("words=" + cwords);
            System.out.println("punctuation marks=" + count);
            prw.println("punctuation marks=" + count);

         } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
