package by.it.kurmaz.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String path (Class<?> cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path;
    }

    private static String path (String name) {
        return path(TaskA.class) + name;
    }

    public static void main(String[] args) {
        String filename = path("dataTaskA.bin");

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filename))) {
            for (int i = 0; i < 20; i++) {
                outputStream.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();
        double sum = 0;
        int count = 0;
        int number;
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filename))) {

            while (inputStream.available() > 0) {
                number = inputStream.readInt();
                list.add(number);
                sum += number;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printResult(list, sum, count);
    }


    private static void printResult(List<? extends Number> list, double sum, int count) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path("resultTaskA.txt")))) {
            for (Number i : list) {
                System.out.print(i + " ");
                writer.print(i + " ");
            }
            System.out.println();
            writer.println();
            System.out.println("avg=" + sum/count);
            writer.write("avg=" + sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
