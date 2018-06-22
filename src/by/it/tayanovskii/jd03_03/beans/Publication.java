package by.it.tayanovskii.jd03_03.beans;

public class Publication {
    private long id;
    private String title;
    private int number;
    private String date;
    private String description;
    private double price;

    public Publication() {
    }

    public Publication(long id, String title, int number, String date, String description, double price) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.date = date;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", number=" + number +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
