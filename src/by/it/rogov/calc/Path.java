package by.it.rogov.calc;



import java.io.File;

public class Path {
    private static String path(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    static String path(String filename) {
        return path(Path.class) + filename;
    }
}
