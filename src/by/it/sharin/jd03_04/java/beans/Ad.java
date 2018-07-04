package by.it.sharin.jd03_04.java.beans;

public class Ad {

    private long id;
    private String marka;
    private double price;
    private String model;
    private long users_id;

    public Ad() {
    }

    public Ad(long id, String marka, double price, String model, long users_id) {
        this.id = id;
        this.marka = marka;
        this.price = price;
        this.model = model;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}
