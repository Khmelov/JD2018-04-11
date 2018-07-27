package by.test.SCAND.java.bean;

public class Goods {
    public Goods() {
    }
    private int idgoods;
    private String name;
    private String description;
    private double price;
    private Object photo;
    private int user_iduser;

    public Goods(int idgoods, String name, String description, double price, Object photo, int user_iduser) {
        this.idgoods = idgoods;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.user_iduser = user_iduser;
    }

    public int getIdgoods() {
        return idgoods;
    }

    public void setIdgoods(int idgoods) {
        this.idgoods = idgoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public int getUser_iduser() {
        return user_iduser;
    }

    public void setUser_iduser(int user_iduser) {
        this.user_iduser = user_iduser;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "idgoods=" + idgoods +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", photo=" + photo +
                ", user_iduser=" + user_iduser +
                '}';
    }
}
