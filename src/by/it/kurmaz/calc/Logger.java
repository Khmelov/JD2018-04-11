package by.it.kurmaz.calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {

    private static String filename = "log.txt";
    private static Class cl = Logger.class;
    private static Path path = Paths.get(getPath(cl) + filename);

    private static String getPath (Class cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path;
    }

    static void Log (String message) {
        try {
            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            int size = (int) Files.lines(path).count();
            int index = 0;
            if (size >=1)
                index = getIndex(size);
            if (size > 49) {
                int remove = index - 49;
                String removeLog = "[Log #" + remove + "]";
                String[] logs = Files.lines(path).filter(e -> !(e.contains(removeLog))).toArray(String[]::new);
                try (FileWriter writer = new FileWriter(path.toString())) {
                for (String log : logs) {
                        writer.write(log + "\n");
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try (FileWriter writer = new FileWriter(path.toString(), true)) {
                writer.write("[Log #" + (index + 1) + "]: " + formatForDateNow.format(date) + " " + message + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getIndex(int size) {
        String last = null;
        int grid = 0;
        int bracket = 0;
        try {
            last = Files.lines(path).skip(size - 1).findFirst().toString();
            grid = last.indexOf('#');
            bracket = last.indexOf(']');
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (last != null) {
            return Integer.parseInt(last.substring(grid + 1, bracket));
        }
        else
            return 0;
    }
}
