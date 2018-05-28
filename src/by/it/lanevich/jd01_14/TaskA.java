package by.it.lanevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String path(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    private static String path(String filename) {
        return path(TaskA.class) + filename;
    }

    public static void main(String[] args) {
        String filename = path("dataTaskA.bin");
        generateIntFile(filename);
        List<Integer> list = new ArrayList<>();
        readIntFile(filename, list);
        printResult(list);
    }

    private static void printResult(List<Integer> list) {
        try (PrintWriter ourOut =
                     new PrintWriter(
                             new FileWriter(path("resultTaskA.txt")))) {
            double sum = 0;
            for (Integer i : list) {
                System.out.print(i + " ");
                ourOut.print(i + " ");
                sum += i;
            }

            System.out.println("\navg=" + sum / list.size());
            ourOut.println("\navg=" + sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readIntFile(String filename, List<Integer> list) {
        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(filename)))
        ) {

            while (dis.available() > 0) {
                int i = dis.readInt();
                list.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateIntFile(String filename) {
        try (DataOutputStream dos =
                     new DataOutputStream(
                             new FileOutputStream(filename))
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
