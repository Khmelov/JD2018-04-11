package by.it.sharin.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        // split text into lines
        String[] lines = Poem.text.split("\\n");
        // get max possible length
        int maxLength = lines[0].length();
        for (String line : lines) {
            if (line.length() > maxLength){
                maxLength = line.length();
            }
        }

        for (String line : lines) {
            int missingLength = maxLength - line.length();
            int spacesNumber = line.replaceAll("[^ ]", "").length();
            int totalSpacesToAdd = missingLength + spacesNumber;
            String[] words = line.split("\\s+");

            //distribute spaces between words
            while (totalSpacesToAdd > 0){
                for (int i = 0; i < words.length - 1; i++) {
                    if (totalSpacesToAdd > 0) {
                        words[i] += " ";
                        totalSpacesToAdd--;
                    }else
                        break;
                }
            }

            StringBuilder builder = new StringBuilder();
            for(String s : words) {
                builder.append(s);
            }
            System.out.println(builder.toString());
        }
    }
}
