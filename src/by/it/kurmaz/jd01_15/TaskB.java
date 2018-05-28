package by.it.kurmaz.jd01_15;

import java.io.*;

public class TaskB {
    /**
     * @author Pavel Kurmaz
     * @param cl - defines a class
     * @return = nothing to return
     */
    private static String path (Class<?> cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path; //однострочный №1
    }
    /*
    многострочный №2


     */
    public static void main(String[] args) {
        Class cl = TaskB.class;
        String filename = path(cl) + "TaskB.java"; //однострочный №2
        char c;
        boolean trigger = false;
        boolean lineTrigger = false;
        boolean multiLineTrigger = false;
        StringBuilder sb = new StringBuilder();
        //однострочный №3
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                c = (char) reader.read();
                if ((!lineTrigger) && (!multiLineTrigger)) {
                    if ((!trigger) && (c == '/'))
                        trigger = true;
                    else if ((trigger) && (c == '/')){
                        lineTrigger = true;
                        trigger = false;
                    }
                    else if ((trigger) && (c == '*')) {
                        multiLineTrigger = true;
                        trigger = false;
                    }
                    else if ((trigger) && (c != '*') && (c != '/')) {
                        trigger = false;
                        sb.append('/');
                        sb.append(c);
                    }
                    else
                        sb.append(c);
                }
                else if (multiLineTrigger) {
                    if ((!trigger) && (c == '*'))
                        trigger = true;
                    else if ((trigger) && (c == '/')) {
                        trigger = false;
                        multiLineTrigger = false;
                    }
                    else
                        trigger = false;
                }
                else if (lineTrigger) {
                    if (c == '\n') {
                        lineTrigger = false;
                        sb.append(c);
                    }

                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        /*
        многострочный №1
         */
        try(PrintWriter writer = new PrintWriter(new FileWriter(path(cl)+ "TaskB.txt"))) {
            writer.print(sb.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}
