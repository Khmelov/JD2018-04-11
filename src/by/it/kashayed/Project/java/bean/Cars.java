package by.it.kashayed.Project.java.bean;

public class Cars {
    public Cars() {
    }

    private int id;
    private String model;
    private int year;
    private String color;
    private double vengine;
    private double price;
    private int owner_id;

    public Cars(int id, String model, int year, String color, double vengine, double price, int owner_id) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vengine = vengine;
        this.price = price;
        this.owner_id = owner_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getVengine() {
        return vengine;
    }

    public void setVengine(double vengine) {
        this.vengine = vengine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", vengine='" + vengine + '\'' +
                ", price='" + price + '\'' +
                ", owner_id=" + owner_id +
                '}';
    }


}
