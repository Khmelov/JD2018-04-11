package by.it.kurmaz.calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Logger {

    private Path path = Paths.get(getPath(Logger.class) + "log.txt");

    private LogBuilder logBuilder;

    private String message;

    private String getPath (Class cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path;
    }

    void setLogBuilder(LogBuilder builder) {
        this.logBuilder = builder;
    }

    void createLog (String message) {
        this.message = logBuilder.getMessage(message);
        Log();
    }

    void createLog (CalcException e) {
        this.message = logBuilder.getMessage(e);
        Log();
    }

    private void Log () {
        try {
            int size = (int) Files.lines(path).count();
            int index = 0;
            if (size >=1)
                index = getIndex(size);
            if (size > 49) {
                int removeIndex = index - 49;
                String[] logs = Files.lines(path).filter(e -> !(e.contains("[Log #" + removeIndex + "]"))).toArray(String[]::new);
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
                writer.write("[Log #" + (index + 1) + "]: " + message + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getIndex(int size) {
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

    public void start() {
        message = logBuilder.createStartMessage();
        Log();
    }

    public void finish() {
        message = logBuilder.createEndMessage();
        Log();
    }
}
