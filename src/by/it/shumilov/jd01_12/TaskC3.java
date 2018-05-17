package by.it.shumilov.jd01_12;



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    private static   Map <String,String> BRACKETS = new HashMap<String, String>(){{put("}","{");put("]","[");put(")","(");}};
    public static void main(String[] args) {
        String s = "package by.it.shumilov.jd01_12;\n" +
                "\n" +
                "import java.util.*;\n" +
                "\n" +
                "public class TaskB2 {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(process(new ArrayList<String>(Arrays.asList(\"1\", \"2\", \"3\",\"4\",\"5\", \"6\"))));\n" +
                "        LinkedList<String> ll = new LinkedList<>(Arrays.asList(\"1\", \"2\", \"3\",\"4\",\"5\", \"6\"));\n" +
                "        System.out.println(process(ll));\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    static String process(ArrayList<String> peoples){\n" +
                "\n" +
                "        int i = 1;\n" +
                "        while (peoples.size()>1){\n" +
                "            Iterator<String> it = peoples.iterator();\n" +
                "            while(it.hasNext()){\n" +
                "                it.next();\n" +
                "                if (i%2 == 0) {\n" +
                "                    it.remove();\n" +
                "                }\n" +
                "                i++;\n" +
                "            }\n" +
                "        }\n" +
                "        return  peoples.get(0);\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    static String process(LinkedList<String> peoples){\n" +
                "        int i = 1;\n" +
                "        while (peoples.size()>1){\n" +
                "            Iterator<String> it = peoples.iterator();\n" +
                "            while(it.hasNext()){\n" +
                "                it.next();\n" +
                "                if (i%2 == 0) {\n" +
                "                    it.remove();\n" +
                "                }\n" +
                "                i++;\n" +
                "            }\n" +
                "        }\n" +
                "        return  peoples.get(0);\n" +
                "    }\n" +
                "}\n";
        System.out.println(eroorCode(s));
    }
    static boolean eroorCode(String s){
        LinkedList<String> list = new LinkedList<String>();
        Pattern pt = Pattern.compile("[\\[\\]\\{\\}\\(\\)]");
        Matcher math = pt.matcher(s);
        Set<String> keys = BRACKETS.keySet();
        while(math.find()){
            String element = math.group();

            if(keys.contains(element) ){

                if(list.size() == 0)
                    return false;
                if (BRACKETS.get(element).contains( list.removeLast())){

                    continue;}
                else
                    return false;

            }
            else
                list.add(element);
        }
        if(list.size() == 0)
            return  true;
        else
            return false;

    }

}
