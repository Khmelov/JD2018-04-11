package by.it.shumilov.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

public class TaskC {
    public static void main(String[] args) throws IOException {
        String line;
        Path path = Paths.get(path());


        //String path = TaskA.path("TaskA.java");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        long size = basicFileAttributes.size();
        SimpleDateFormat df=new SimpleDateFormat("EEE dd.MM.yy HH:mm");

        String d1 = df.format(basicFileAttributes.creationTime().toMillis());
        System.out.println( TaskC.class.getPackage().getName());

        Scanner sc=new Scanner(System.in);
        System.out.print(path+">");
        while (!(line = sc.nextLine()).equals("end")){
            if(line.length() > 0 )
            {
                String[] arggs = line.split(" ");
                if (arggs.length > 1){
                    if(arggs[0].equals("cd")){
                        if (arggs[1].equals("..")){
                            //if (path.getParent() == null) System.out.println(path.getRoot());
                            if (!path.equals(path.getRoot()))/// &&  Files.exists(path.getParent()))

                                path = path.getParent();
                            //if (Files.isDirectory(path.getRoot()))
                        }
                        else if (Files.isDirectory(path.resolve(arggs[1])))
                            path = path.resolve(arggs[1]);
                    }

                }
                else if (arggs[0].equals("dir")){
                    String[] l1 = Files.list(path)
                            .map((a)->df.format((new File(String.valueOf(a))).lastModified()) + "  " + a.getFileName().toString())
                            .toArray(String[]::new);
                    for (String s : l1) {
                        System.out.println(s);
                    }
                }
                /*else
                    System.out.println();*/
            }
            //System.out.println();
            System.out.print(path+">");
        }
    }
    private  static  String path(){
        String[] a = TaskC.class.getPackage().getName().split("\\.");

        return  System.getProperty("user.dir") +File.separator+"src"+File.separator+String.join(File.separator,a) ;
    }
}

