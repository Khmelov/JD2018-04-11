package by.it.dkruchek.jd01_15;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/23/2018.
 */
public class TaskC {

    private static String secondsToDate(long seconds, String format){
        Date date = new Date(seconds);
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    private static void pwd(File dir){
        System.out.println(dir.getAbsolutePath());
    }

    public static void main(String[] args){

    String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "dkruchek" +
            File.separator + "jd01_15";
    File dir = new File(path);
    Scanner sc = new Scanner(System.in);

    String line;
    while(!(line = sc.nextLine()).equals("end")){
        line = line.trim();
        if (line.equals("dir")){
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    String isDir = file.isDirectory() ? "<DIR>" : "";
                    String fileSize = file.isDirectory() ? "" : "" + file.length();

                    System.out.printf("%s  %s     %s    %6s  %s\n", secondsToDate(file.lastModified(), "MM/dd/yyyy"),
                                                                    secondsToDate(file.lastModified(), "HH:mm a"),
                                                                    isDir, fileSize, file.getName());
                }
            } else System.out.println("");
        }
        if (line.startsWith("cd")){
            String[] cmdPath = line.split("\\s+");
            if (cmdPath[1].equals("..")){
                dir = dir.getParentFile();
                pwd(dir);
            }
            else {
                String newPath = dir.getAbsolutePath() + File.separator + cmdPath[1];
                File newDir = new File(newPath);
                if (!newDir.exists()) System.out.println("No such directory");
                else{dir = newDir; pwd(dir);}
            }
        }
        if (line.equals("pwd")){
            pwd(dir);        }
    }
        System.out.println("Bye");
    }
}
