package by.it.kashayed.Project.bean;

public class Cars {
    public Cars() {
    }

    private int id;
    private String model;
    private String year;
    private String color;
    private String vengine;
    private String price;
    private int owner_id;

    public Cars(int id, String model, String year, String color, String vengine, String price, int owner_id) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vengine = vengine;
        this.price = price;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVengine() {
        return vengine;
    }

    public void setVengine(String vengine) {
        this.vengine = vengine;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}
