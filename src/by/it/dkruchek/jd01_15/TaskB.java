package by.it.dkruchek.jd01_15;

import java.io.*;

/**
 * Created by Dmitriy.Kruchek on 5/23/2018.
 */
public class TaskB {
    /*
    Class to remove all kind of comments
     */
    private static String path(Class<?> cls){
        String prjRoot = System.getProperty("user.dir");
        String pkg = cls.getName()
                .replace(".", File.separator)
                .replaceAll(cls.getSimpleName(), "");
        return prjRoot +  File.separator + "src" + File.separator + pkg;
    }
    // Methods returns filepath of a specified class
    public static String path(String filename){
        return path(TaskB.class) + filename;
    }

    public static void main(String[] args) {
        String INLINE_COMMENT = "//";
        String BLOCK_COMMENT_STARTED = "/*";
        String BLOCK_COMMENT_FINISHED = "*/";
        // podozrenie na commentarii
        // ENUM MODE: mogostrochnii odnostrochnii, podozrenie na kommentarii, norm rejin
        String filename = path("TaskB.java");
        String outFile = path("TaskB.txt");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int offset;
            while ((line=reader.readLine())!=null) {
                if (-1 != (offset = line.indexOf(INLINE_COMMENT))) {
                    line = line.substring(0, offset);
                }
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int startIndex, endIndex;
        while ((startIndex=sb.indexOf(BLOCK_COMMENT_STARTED))>=0 && (endIndex=sb.indexOf(BLOCK_COMMENT_FINISHED))>=0) {
            sb.delete(startIndex, endIndex+2);
        }

        try (PrintWriter writer = (new PrintWriter(
                new FileWriter(outFile)))){
                writer.print(sb);
            }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    /*
    End of class to remove all kind of comments
     */
