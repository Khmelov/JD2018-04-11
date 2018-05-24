package by.it.kurmaz.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskB {

    public static void main(String[] args) {
        String filename = getFilePath(TaskB.class, "text.txt");
        System.out.println(filename);
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> words = new ArrayList<>();
        List<String> points = new ArrayList<>();
        for (String line: lines) {
            String[] sent = line.split("[^А-Яа-яё]+");
            words.addAll(Arrays.asList(sent));
            sent = line.split("[А-Яа-яё\\s\\n]+");
            for (String s: sent) {
                if (s.length() != 0)
                    points.add(s);
            }
        }
        System.out.println("words=" + words.size() + ", punctuation marks=" + points.size());
        printResult(words, points);

    }

    private static void printResult(List<String> words, List<String> points) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFilePath(TaskB.class,"resultTaskB.txt")))) {
        writer.write("words=" + words.size() + ", punctuation marks=" + points.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath (Class<?> cl, String name) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path + name;


    }
}
