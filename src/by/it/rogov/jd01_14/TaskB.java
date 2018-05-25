package by.it.rogov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {

    public static void main(String[] args) {

        String path = TaskA.path(TaskB.class) + "text.txt";
            StringBuilder sb = new StringBuilder();
        try (
                BufferedReader read = new BufferedReader(
                        new FileReader(path))

        ) {

            String str = null;
            while (null != (str = read.readLine())) {
                sb.append(str.trim()).append(" ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        Matcher math1 = Pattern.compile("[А-Яa-яЁё]+").matcher(sb);
        Matcher math2 = Pattern.compile("[!,.:\\\\-]+").matcher(sb);


        int words = 0;
        int marks = 0;
        while (math1.find()) words++;
        while (math2.find()) marks++;
        System.out.println("words=" + words + ", " + "pounctuaion marks="+marks);
        String newWrite = TaskA.path(TaskB.class)+"resultTaskB.txt";
        try(
                PrintWriter printWriter = new PrintWriter(
                     new FileWriter(newWrite))
        ){

            printWriter.print("words=" + words +", "+ "pounctuaion marks=" + marks);

        }catch (IOException e){
            e.printStackTrace();
        }

    }





}
