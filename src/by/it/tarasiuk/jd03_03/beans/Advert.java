package by.it.tarasiuk.jd03_03.beans;

public class Advert {
    private long id;
    private String brand;
    private String model;
    private short year;
    private String type;
    private String grade;
    private String color;
    private double price;
    private String description;
    private long users_id;

    public Advert() {
    }

    public Advert(long id, String brand, String model, short year, String type, String grade, String color, double price, String description, long users_id) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.type = type;
        this.grade = grade;
        this.color = color;
        this.price = price;
        this.description = description;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}
