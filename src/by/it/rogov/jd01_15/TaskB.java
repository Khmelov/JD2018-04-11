package by.it.rogov.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *sdfsdf
 * sdfsdf
 * fdsdfs
 * @typeCout
 */
public class TaskB {
    public static void main(String[] args) {

        boolean typeComment3=true;
        boolean typeComment2=true; //true- false-*
        boolean typeComment1=true;// true- false-/

        String fileName = TaskA.path("TaskB.java");
        System.out.println(fileName);
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader(fileName));
        ) {
            StringBuilder sb=new StringBuilder();
            while (reader.ready()){
                char ch=(char)reader.read();
//                if (ch=='/'&&)
                sb.append(ch); //Привет
            }
            /*
            fdsfsdfsdfsdf sd sdfsd
             */
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
/*
           fdsfsdfsdfsdf sd sdfsd
*/