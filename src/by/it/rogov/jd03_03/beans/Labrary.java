package by.it.rogov.jd03_03.beans;

public class Labrary {
    private long id;
    private String textFree;
    private String textPay;

    public Labrary() {
    }

    
    public Labrary(long id, String textFree, String textPay) {
        this.id = id;
        this.textFree = textFree;
        this.textPay = textPay;
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

    public String getTextPay() {
        return textPay;
    }

    public void setTextPay(String textPay) {
        this.textPay = textPay;
    }


    @Override
    public String toString() {
        return "Labrary{" +
                "id=" + id +
                ", textFree='" + textFree + '\'' +
                ", textPay='" + textPay + '\'' +
                '}';
    }
}
