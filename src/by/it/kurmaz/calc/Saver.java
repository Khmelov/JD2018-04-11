package by.it.kurmaz.calc;

import by.it._examples_.jd02_04.Calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Saver {
    private static String filename = "var.txt";
    private static Class cl = Saver.class;

    static void save (HashMap<String, Var> hashMap) throws CalcException {
        try(FileWriter writer = new FileWriter(getPath(cl) + filename)) {
            Set<Map.Entry<String, Var>> set = hashMap.entrySet();
            for (Map.Entry<String, Var> entry: set) {
                writer.write(entry.getKey() + "=" + entry.getValue().toString() + "\n");
            }
        } catch (IOException e) {
            throw new CalcException("Save failed!", e);
        }
    }

    private static String getPath (Class cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path;
    }

    @SuppressWarnings("deprecation")
    static HashMap<String, Var> recover() throws CalcException {
        HashMap<String, Var> hashMap = new HashMap<>();
        String line;
        File recover = new File(getPath(cl) + filename);
        if (!recover.exists())
            return null;
        try(BufferedReader reader = new BufferedReader( new FileReader(getPath(cl) + filename))) {
            while (reader.ready()) {
                line = reader.readLine();
                String[] content = line.split("=");
                hashMap.put(content[0], Var.createVar(content[1]));
            }
        } catch (IOException e) {
            throw new CalcException("Recovery failed!", e);
        }
        return hashMap;
    }
}
