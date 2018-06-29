package by.it.mokhart.project.java.beans;

public class Ad {

    long id;
    String description;
    double price;
    String size;
    String fabric;
    String colour;
    String sex;
    String producer;
    long users_id;

    public Ad() {
    }

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

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public Ad(long id, String description, double price, String size, String fabric, String colour, String sex, String producer, long users_id) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.size = size;
        this.fabric = fabric;
        this.colour = colour;
        this.sex = sex;
        this.producer = producer;
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", fabric=" + fabric +
                ", colour=" + colour +
                ", sex=" + sex +
                ", producer='" + producer + '\'' +
                ", user_id=" + users_id +
                '}';
    }
}
