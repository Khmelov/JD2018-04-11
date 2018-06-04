package by.it.dkruchek.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/23/2018.
 */
//TODO: USE NIO HERE
public class TaskC_nio {

    private static String secondsToDate(long seconds, String format){
        Date date = new Date(seconds);
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    private static void pwd(Path dir){
        System.out.println(dir.toAbsolutePath());
    }

    public static void main(String[] args){

        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "dkruchek" +
                File.separator + "jd01_15";
        //File dir = new File(path);
        Path dir = Paths.get(path);
        Scanner sc = new Scanner(System.in);
        String line;

        while(!(line = sc.nextLine()).equals("end")){
            line = line.trim();
            if (line.equals("dir")){
                //File[] files = dir.listFiles();

                //for (File file : files) {
                for (Path child: dir) {
                    String isDir = Files.isDirectory(child) ? "<DIR>" : "";
                    String dateString = "";
                    try {
                        FileTime lastModifiedTime = Files.getLastModifiedTime(child);
                        System.out.println(lastModifiedTime);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


//                System.out.printf("%s  %s     %s       %s\n", secondsToDate(Files.getLastModifiedTime(child), "MM/dd/yyyy"),
//                        secondsToDate(file.lastModified(), "HH:mm a"),
//                        isDir, file.getName());
                }
            }

            if (line.startsWith("cd")){
                String[] cmdPath = line.split("\\s+");
                if (cmdPath[1].equals("..")){
                    //dir = dir.getParentFile();
                    dir = dir.getParent();
                    pwd(dir);
                }
                else {
                    String newPath = dir.toAbsolutePath() + File.separator + cmdPath[1];
                    Path newDir = new File(newPath).toPath();
                    if (!Files.exists(newDir)) System.out.println("No such directory");
                    else{dir = newDir; pwd(dir);}
                }
            }
            if (line.equals("pwd")){
                pwd(dir);        }
        }
        System.out.println("Bye");
    }
}
