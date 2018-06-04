package by.it.shumilov.jd01_15;

import java.io.*;
import java.nio.file.Files;

/**
 * asdasd
 * asdasdasd
 * asdasd
 * asdasd
 */

public class TaskB {
    private enum Points {Text, Comment, Comments, Perhaps, Comsperchaps}

    public static void main(String[] args) {
        String path = TaskA.path("TaskB.java");
        String pathOut = TaskA.path("TaskB.txt");
        Points point = Points.Text;

        int as = 0;
        /*sfmskmkgmfmdjhndhdngkd
         lmfksmgkmkdgmkmg*/
        StringBuilder sb = new StringBuilder(); //gjfefgierjreijgrg

        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()){
                char ch = (char) br.read();
                //System.out.println(point);
                if(point == Points.Text)
                    sb.append(ch);


                if((point == Points.Text) && (ch == '/')){
                    point=Points.Perhaps;
                    continue;
                }

                if(point == Points.Perhaps){
                    if((ch == '*') | (ch =='/')){
                        as= sb.lastIndexOf("/");
                        sb.deleteCharAt(as);
                        if (ch == '*')
                            point=Points.Comments;
                        else
                            point=Points.Comment;
                        continue;
                    }
                    else {
                        point = Points.Text;
                        continue;
                    }
                }


                if(point == Points.Comment && ch == '\n') {
                    point = Points.Text;
                    continue;
                }


                if(point == Points.Comments && (ch == '*')){
                    point = Points.Comsperchaps;
                    continue;
                }

                if (point == Points.Comsperchaps ){
                    if(ch == '/')
                        point = Points.Text;
                    else
                        point = Points.Comments;
                    continue;
                }



                //gjfefgierjreijgrg


            }
         /*sfmskmkgmfmdjhndhdngkd
         lmfksmgkmkdgmkmg*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);

        try (PrintWriter pw = new PrintWriter(new FileWriter(pathOut))){

            System.out.print(sb);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
