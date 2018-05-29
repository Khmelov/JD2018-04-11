package by.it.shekh.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskC {
    private static String SLASH = File.separator;

    private static String path(Class<?> cl) {
        String rootProj = System.getProperty("user.dir") + File.separator + "src";
        String path = cl.getName().replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return rootProj + File.separator + path;
    }

    private static String modificationDate(long sec, String dateFormat) {
        Date date = new Date(sec);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat(dateFormat);

        return dateFormat1.format(date);
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + SLASH + "src" +
                SLASH + "by" + SLASH + "it" + SLASH + "shekh" + SLASH + "jd01_15" + SLASH;
        File dirFile = new File(path);
        Scanner sc = new Scanner(System.in);
        String strl;
        while (!(strl = sc.nextLine().trim()).equals("end")) {
            strl = strl.trim();
            if (strl.startsWith("cd")) {
                String[] paths = strl.split("\\s+");
                    if(paths[1].equals("..")){
                        dirFile=dirFile.getParentFile();
                        System.out.println(dirFile.getAbsolutePath());
                    }
                    else
                    {
                        String newPath=dirFile.getAbsolutePath()+SLASH+paths[1];
                        File newDir=new File(newPath);
                        if(newDir.exists()){
                            dirFile=newDir;
                            System.out.println(dirFile.getAbsolutePath());
                        }
                        else
                            System.out.println("Unknown path "+newDir.getAbsolutePath());
                    }


            }
            if (strl.equals("dir")) {
                File[] files = dirFile.listFiles();
                for (File file : files) {
                    String dir = file.isDirectory() ? "<DIR>" : "";
                    String size = file.isFile() ? "" + file.length() : "";
                    System.out.printf("%s  %s     %s   %6s %s\n", modificationDate(file.lastModified(), "dd.MM.yyyy"),
                            modificationDate(file.lastModified(), "HH:mm"), dir, size, file.getName());

                }
            }

        }

    }
}
