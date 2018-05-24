package by.it.lanevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String path(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    private static String path(String filename) {
        return path(TaskB.class) + filename;
    }

    public static void main(String[] args) {
        String filename = path("text.txt");
        String filenameout = path("resultTaskB.txt");
        StringBuilder t=new StringBuilder();

        try (BufferedReader dis =
                     new BufferedReader(
                             new FileReader(filename))) {
            String res = dis.readLine();
            while (res !=null){
               t.append(" ").append(res);
               res = dis.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern words=Pattern.compile("[А-ЯЁёа-я]+");
        Pattern marks=Pattern.compile("[-.,:;!?]+");
        Matcher m1=words.matcher(t);
        int countword=0;
        while(m1.find()){
            countword++;
        }
        Matcher m2=marks.matcher(t);
        int countmark=0;
        while(m2.find()){
            countmark++;
        }
        System.out.println("words="+countword+", punctuation marks="+countmark);

        try (PrintWriter pr = new PrintWriter(new FileWriter(filenameout))){
            pr.print("words="+countword+", punctuation marks="+countmark);
        } catch (IOException e) {
            e.printStackTrace();
        }
}}


//    В классе TaskB нужно выполнить следующие шаги:
//         В файле с текстом text.txt нужно подсчитать общее количество знаков
//        препинания и слов
//         Вывести результат на консоль в виде одной строки:
//        words=123, punctuation marks=15
//         Продублировать вывод в консоль в файл resultTaskB.txt
//1. Прочитать txt файл в коллекцию ArrayList.
//2. Матчер\патчер
//3. Посчитать количество слов, знаков препинания
//4. Вывести на консоль, записать в файл resultTaskB.txt
