package by.it.zakharenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskB {

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path += cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        return path;
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

    public static void main(String[] args) {
        String filename = getPath(TaskB.class, "text.txt");
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> words = new ArrayList<>();
        List<String> marks = new ArrayList<>();
        for (String line : list) {
            String[] arr = line.split("[^А-Яа-яё]+");
            words.addAll(Arrays.asList(arr));
            arr = line.split("[А-Яа-яё\\s\\n]+");
            for (String s : arr) {
                if (s.length() != 0)
                    marks.add(s);
            }
        }

        System.out.println("words=" + words.size() + ", punctuation marks=" + marks.size());
        printResult(words, marks);
    }


    private static void printResult(List<String> words, List<String> marks) {
        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(getPath(TaskB.class, "resultTaskB.txt")))) {
            writer.write("words=" + words.size() + ", punctuation marks=" + marks.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
