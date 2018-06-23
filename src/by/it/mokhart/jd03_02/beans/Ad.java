package by.it.mokhart.jd03_02.beans;

public class Ad {

    long id;
    String description;
    double price;
    String size;
    String fabric;
    String colour;
    String sex;
    String producer;
    long user_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Ad(long id, String description, double price, String size, String fabric, String colour, String sex, String producer, long user_id) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.size = size;
        this.fabric = fabric;
        this.colour = colour;
        this.sex = sex;
        this.producer = producer;
        this.user_id = user_id;
    }
}
