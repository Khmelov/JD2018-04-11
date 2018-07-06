package by.it.rogov.jd03_04.beans;

public class Labrary {
    private long id;
    private String textFree;
    private String textPay;
    private long users_id;

    public Labrary() {
    }

    public Labrary(long id, String textFree, String textPay, long users_id) {
        this.id = id;
        this.textFree = textFree;
        this.textPay = textPay;
        this.users_id = users_id;
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

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Labrary{" +
                "id=" + id +
                ", textFree='" + textFree + '\'' +
                ", textPay='" + textPay + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}
