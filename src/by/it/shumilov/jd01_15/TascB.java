package by.it.shumilov.jd01_15;

import java.io.*;

public class TascB {
    private enum Points {Text, Comment, Coments, Perhaps, Notext}

    public static void main(String[] args) {
        String path = TaskA.path("TaskB");
        Points p = Points.Text;

        StringBuilder sb = new StringBuilder();

        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()){
                char ch = (char) br.read();
                if(p==Points.Perhaps )
                if(ch == '/')
                    p=Points.Perhaps;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
