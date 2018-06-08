package by.it.shumilov.Calc;

public class Report {

    private String caption="";
    private String time = "";
    private String operations = "";

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n",caption,time,operations);

    }
}
