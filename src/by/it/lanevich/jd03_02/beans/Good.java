package by.it.lanevich.jd03_02.beans;

public class Good {
    long id;
    long idgood;
    String goodname;
    String description;
    int piecies;
    double price;


    public Good() {
    }

    public Good(long id, long idgood, String goodname, String description, int piecies, double price) {
        this.id = id;
        this.idgood = idgood;
        this.goodname = goodname;
        this.description = description;
        this.piecies = piecies;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdgood() { return idgood; }

    public void setIdgood(long idgood) {
        this.idgood = idgood;
    }

    public String getGoodname() { return goodname; }

    public void setGoodname(String goodname) { this.goodname = goodname; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description; }

    public int getPiecies() { return piecies; }

    public void setPiecies(int piecies) {
        this.piecies = piecies;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", idgood='" + idgood + '\'' +
                ", goodname='" + goodname + '\'' +
                ", description='" + description + '\'' +
                ", piecies='" + piecies + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
