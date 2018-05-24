package by.it.kurmaz.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        Class cl = TaskC.class;
        File current = new File(getPath(cl));
        System.out.println(current.getAbsolutePath());
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.contains("cd")) {
                current = execute(line, current);
                System.out.println(current.getAbsolutePath());
            }
            if (line.contains("dir")) {
                File[] content = current.listFiles();
                if (content != null) {
                    for (File element : content) {
                        String dir;
                        if (element.isDirectory())
                            dir = " DIR ";
                        else
                            dir = "     ";
                        Date date = new Date(element.lastModified());
                        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
                        System.out.println(formatForDateNow.format(date) + dir + element.getName());
                    }
                }
                else
                    System.out.println("Wrong directory path!");
            }
        }
    }

    private static File execute(String line, File current) {
        String[] divide = line.split("cd");
        String command = divide[1].trim();
        if (command.contains("..")) {
            int slash = current.getAbsolutePath().lastIndexOf(File.separator);
            String path = (String) current.getAbsolutePath().subSequence(0, slash+1);
            return new File (path);
        }
        else
            return new File (current.getAbsolutePath() +  File.separator + command);
    }

    private static String getPath (Class cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path;
    }

}
