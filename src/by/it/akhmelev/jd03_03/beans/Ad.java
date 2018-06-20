package by.it.akhmelev.jd03_03.beans;

public class Ad {

    long id;
    String description;
    int flat;
    int flats;
    int rooms;
    double area;
    double price;
    String address;
    long users_id;

    public Ad() {
    }

    public Ad(long id, String description, int flat, int flats, int rooms, double area, double price, String address, long users_id) {
        this.id = id;
        this.description = description;
        this.flat = flat;
        this.flats = flats;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.address = address;
        this.users_id = users_id;
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

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getFlats() {
        return flats;
    }

    public void setFlats(int flats) {
        this.flats = flats;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                ", description='" + description + '\'' +
                ", flat=" + flat +
                ", flats=" + flats +
                ", rooms=" + rooms +
                ", area=" + area +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}
