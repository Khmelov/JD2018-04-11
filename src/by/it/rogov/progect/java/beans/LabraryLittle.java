package by.it.rogov.progect.java.beans;

public class LabraryLittle {

    private long id;
    private String textFree;

    public LabraryLittle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextFree() {
        return textFree;
    }

    public void setTextFree(String textFree) {
        this.textFree = textFree;
    }

    public LabraryLittle(long id, String textFree) {

        this.id = id;
        this.textFree = textFree;
    }

    @Override
    public String toString() {
        return "LabraryLittle{" +
                "id=" + id +
                ", textFree='" + textFree + '\'' +
                '}';
    }
}
