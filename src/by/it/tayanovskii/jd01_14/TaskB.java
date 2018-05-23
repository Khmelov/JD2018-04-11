package by.it.tayanovskii.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//В классе TaskB нужно выполнить следующие шаги:
//         В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
//        препинания и слов
//         Вывести результат на консоль в виде одной строки:
//        words=123, punctuation marks=15
//         Продублировать вывод в консоль в файл resultTaskB.txt



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
        String fileName=path("text.txt");
        StringBuilder stringBuilder = ReadFileToStringBuilder(fileName);
        printResult(stringBuilder);
    }

    private static void printResult(StringBuilder stringBuilder) {
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(path("resultTaskB.txt"))))) {

            System.out.println("words=" + countWords(stringBuilder.toString()) + ", punctuation marks=" + countPunctuation(stringBuilder.toString()));
            printWriter.println("words=" + countWords(stringBuilder.toString()) + ", punctuation marks=" + countPunctuation(stringBuilder.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder ReadFileToStringBuilder(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            while (reader.ready())
            {
                stringBuilder.append(reader.readLine());
                stringBuilder.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    private static int countWords (String inputStr)
    {
        int count=0;
        Pattern pattern=Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher=pattern.matcher(inputStr);
        while (matcher.find()) count++;
        return  count;
    }

    private static int countPunctuation(String inputStr)
    {
        int count=0;
        Pattern pattern=Pattern.compile("[,;:.!?-]+");
        Matcher matcher=pattern.matcher(inputStr);
        while (matcher.find()) count++;
        return count;
    }

}
